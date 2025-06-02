package ee.valiit.groomlyback.services;

import ee.valiit.groomlyback.Status;
import ee.valiit.groomlyback.controller.booking.dto.BasketShortInfo;
import ee.valiit.groomlyback.infrastructure.exception.ForeignKeyNotFoundException;
import ee.valiit.groomlyback.infrastructure.exception.PrimaryKeyNotFoundException;
import ee.valiit.groomlyback.persistence.booking.Booking;
import ee.valiit.groomlyback.persistence.booking.BookingRepository;
import ee.valiit.groomlyback.persistence.bookingprocedure.BookingProcedure;
import ee.valiit.groomlyback.persistence.bookingprocedure.BookingProcedureRepository;
import ee.valiit.groomlyback.persistence.groomer.Groomer;
import ee.valiit.groomlyback.persistence.groomer.GroomerRepository;
import ee.valiit.groomlyback.persistence.groomerprocedure.GroomerProcedure;
import ee.valiit.groomlyback.persistence.groomerprocedure.GroomerProcedureRepository;
import ee.valiit.groomlyback.persistence.procedure.Procedure;
import ee.valiit.groomlyback.persistence.user.User;
import ee.valiit.groomlyback.persistence.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingProcedureRepository bookingProcedureRepository;
    private final GroomerProcedureRepository groomerProcedureRepository;
    private final GroomerRepository groomerRepository;
    private final UserRepository userRepository;

    public BookingService(BookingRepository bookingRepository,
                          BookingProcedureRepository bookingProcedureRepository,
                          GroomerProcedureRepository groomerProcedureRepository, GroomerRepository groomerRepository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.bookingProcedureRepository = bookingProcedureRepository;
        this.groomerProcedureRepository = groomerProcedureRepository;
        this.groomerRepository = groomerRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void createBooking(Integer customerUserId, Integer groomerProcedureId) {

        User userCustomer = userRepository.findById(customerUserId)
                .orElseThrow(() -> new ForeignKeyNotFoundException("customerUserId", customerUserId));

        GroomerProcedure groomerProcedure = groomerProcedureRepository.findById(groomerProcedureId)
                .orElseThrow(() -> new PrimaryKeyNotFoundException("groomerProcedureId", groomerProcedureId));

        Booking booking = getExistingOrCreateNewBooking(userCustomer, groomerProcedure.getGroomer());
        updateNewTotalPrice(booking, groomerProcedure);
        bookingRepository.save(booking);

        BookingProcedure bookingProcedure = new BookingProcedure();
        bookingProcedure.setBooking(booking);
        Procedure procedure = groomerProcedure.getProcedure();
        bookingProcedure.setProcedure(procedure);
        bookingProcedure.setPrice(groomerProcedure.getPrice());
        bookingProcedureRepository.save(bookingProcedure);

    }

    private static void updateNewTotalPrice(Booking booking, GroomerProcedure groomerProcedure) {
        BigDecimal currentTotalPrice = booking.getTotalPrice();
        BigDecimal procedurePrice = groomerProcedure.getPrice();
        BigDecimal newTotalPrice = currentTotalPrice.add(procedurePrice);
        booking.setTotalPrice(newTotalPrice);
    }

    private Booking getExistingOrCreateNewBooking(User user, Groomer groomer) {
        Booking booking;

        Optional<Booking> optionalBooking = bookingRepository.findBookingBy(user, Status.PENDING.getCode());
        if (optionalBooking.isPresent()) {
            booking = optionalBooking.get();
        } else {
            booking = new Booking();
            booking.setCustomerUser(user);
            booking.setGroomer(groomer);
            booking.setDate(LocalDate.now());
            booking.setTotalPrice(BigDecimal.valueOf(0));
            booking.setStatus("P");
        }
        return booking;
    }

    public BasketShortInfo getBasketShortInfo(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new PrimaryKeyNotFoundException("userId", userId));

        Optional<Booking> optionalBooking = bookingRepository.findBookingBy(user, Status.PENDING.getCode());
        BasketShortInfo basketShortInfo;
        if (optionalBooking.isPresent()) {
            Integer bookingId = optionalBooking.get().getId();
            Long bookingProceduresCount = bookingProcedureRepository.bookingProceduresCountBy(bookingId);
            basketShortInfo = new BasketShortInfo();
            basketShortInfo.setIsBookingStarted(true);
            basketShortInfo.setBookingId(bookingId);
            basketShortInfo.setNumberOfItems(bookingProceduresCount);
        } else {
            basketShortInfo = new BasketShortInfo();
            basketShortInfo.setIsBookingStarted(false);
        }

        return basketShortInfo;
    }
}
