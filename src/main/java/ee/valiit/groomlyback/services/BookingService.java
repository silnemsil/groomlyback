package ee.valiit.groomlyback.services;

import ee.valiit.groomlyback.controller.booking.dto.BookingRequestDto;
import ee.valiit.groomlyback.persistence.booking.Booking;
import ee.valiit.groomlyback.persistence.booking.BookingRepository;
import ee.valiit.groomlyback.persistence.bookingprocedure.BookingProcedure;
import ee.valiit.groomlyback.persistence.bookingprocedure.BookingProcedureRepository;
import ee.valiit.groomlyback.persistence.groomerprocedure.GroomerProcedure;
import ee.valiit.groomlyback.persistence.groomerprocedure.GroomerProcedureRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingProcedureRepository bookingProcedureRepository;
    private final GroomerProcedureRepository groomerProcedureRepository;

    public BookingService(BookingRepository bookingRepository,
                          BookingProcedureRepository bookingProcedureRepository,
                          GroomerProcedureRepository groomerProcedureRepository) {
        this.bookingRepository = bookingRepository;
        this.bookingProcedureRepository = bookingProcedureRepository;
        this.groomerProcedureRepository = groomerProcedureRepository;
    }

    public void createBooking(BookingRequestDto dto) {
        GroomerProcedure groomerProcedure = groomerProcedureRepository.findById(dto.getProcedureId())
                .orElseThrow(() -> new RuntimeException("Groomer procedure not found"));

        // todo: kontorlli kas booking on uba olemas, kui jah, siis otsi see booking välja (pead sellel total proce muutma
        // todo kui ei ole olemas siis uus booking

        // see osa vaid siis kui pole bookingut
        // 1. Salvesta booking
        Booking booking = new Booking();
        booking.setCustomerUserId(dto.getCustomerUserId());
        booking.setGroomer(groomerProcedure.getGroomer());
        booking.setDate(LocalDate.now()); // või tulevikus valitav kuupäev
        booking.setStatus("A"); // "A" = aktiivne


        // see osa siis ok kui pole bookingut
        BigDecimal currentTotalPrice = dto.getProcedurePrice();

        BigDecimal newTotalPrice = dto.getProcedurePrice();


        booking.setTotalPrice(newTotalPrice);
        bookingRepository.save(booking);

        // 2. Salvesta booking_procedure
        BookingProcedure bookingProcedure = new BookingProcedure();
        bookingProcedure.setBooking(booking);
        bookingProcedure.setProcedure(groomerProcedure.getProcedure());
        bookingProcedure.setPrice(dto.getProcedurePrice());
        bookingProcedureRepository.save(bookingProcedure);
    }
}
