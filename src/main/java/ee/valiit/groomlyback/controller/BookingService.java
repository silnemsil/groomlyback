package ee.valiit.groomlyback.controller;

import ee.valiit.groomlyback.persistence.booking.Booking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    public List<Booking> getAllBookings(){
        return List.of();
    }
}
