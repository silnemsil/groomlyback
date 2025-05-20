package ee.valiit.groomlyback.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class Booking {

    private final Booking booking;

    public Booking(Booking booking) {
        this.booking = booking;
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return null;
    }
}
