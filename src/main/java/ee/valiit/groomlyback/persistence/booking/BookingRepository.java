package ee.valiit.groomlyback.persistence.booking;

import ee.valiit.groomlyback.persistence.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Query("select b from Booking b where b.customerUser = :customerUser and b.status = :status")
    Optional<Booking> findBookingBy(User customerUser, String status);


}
