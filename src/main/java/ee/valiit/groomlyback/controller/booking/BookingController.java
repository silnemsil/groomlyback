package ee.valiit.groomlyback.controller.booking;

import ee.valiit.groomlyback.controller.booking.dto.BookingRequestDto;
import ee.valiit.groomlyback.services.BookingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/groomer-procedure")
    public void createBooking(@RequestBody BookingRequestDto bookingRequestDto) {
        bookingService.createBooking(bookingRequestDto);
    }
}
