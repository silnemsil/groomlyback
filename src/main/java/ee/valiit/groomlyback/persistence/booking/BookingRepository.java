package ee.valiit.groomlyback.persistence.booking;

import ee.valiit.groomlyback.persistence.booking.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
