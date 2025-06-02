package ee.valiit.groomlyback.persistence.bookingprocedure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingProcedureRepository extends JpaRepository<BookingProcedure, Integer> {

    @Query("select count(b) from BookingProcedure b where b.booking.id = :bookingId")
    long bookingProceduresCountBy(Integer bookingId);
}