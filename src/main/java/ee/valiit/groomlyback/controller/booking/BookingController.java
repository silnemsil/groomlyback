package ee.valiit.groomlyback.controller.booking;

import ee.valiit.groomlyback.controller.booking.dto.BasketShortInfo;
import ee.valiit.groomlyback.controller.booking.dto.BookingProcedureDto;
import ee.valiit.groomlyback.services.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/booking/groomer-procedure")
    public void createBooking(@RequestParam Integer customerUserId, @RequestParam Integer groomerProcedureId) {
        bookingService.createBooking(customerUserId, groomerProcedureId);
    }

    @GetMapping("/booking/short-basket-info")
    public BasketShortInfo getBasketShortInfo(@RequestParam Integer userId) {
        return bookingService.getBasketShortInfo(userId);
    }

    @GetMapping("/booking/basket-info")
    public List<BookingProcedureDto> getBasketInfo(@RequestParam Integer bookingId) {
        return bookingService.getBasketInfo(bookingId);
    }

}
