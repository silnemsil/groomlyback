package ee.valiit.groomlyback.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

private final BookingService bookingService;

   public BookingController(BookingService bookingService) {
       this.bookingService = bookingService;
    }

    @GetMapping
    public List<BookingController> getAllBookings() {
        return null;
    }
}
