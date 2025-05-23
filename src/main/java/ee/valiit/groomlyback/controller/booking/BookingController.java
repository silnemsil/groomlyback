package ee.valiit.groomlyback.controller.booking;

import ee.valiit.groomlyback.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;


    @GetMapping("/booking")
    public void getAllBookings() {

    }

}
