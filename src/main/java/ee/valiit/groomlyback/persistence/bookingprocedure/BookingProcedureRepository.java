package ee.valiit.groomlyback.persistence.bookingprocedure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingProcedureRepository extends JpaRepository<BookingProcedure, Integer> {

    @Query("select count(b) from BookingProcedure b where b.booking.id = :bookingId")
    long bookingProceduresCountBy(Integer bookingId);

    @Query("select b from BookingProcedure b where b.booking.id = :bookingId")
    List<BookingProcedure> findBookingProceduresBy(Integer bookingId);

}