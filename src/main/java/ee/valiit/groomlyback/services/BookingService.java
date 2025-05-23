package ee.valiit.groomlyback.services;

import ee.valiit.groomlyback.persistence.booking.BookingMapper;
import ee.valiit.groomlyback.persistence.booking.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;


}
