package ee.valiit.groomlyback.persistence.bookingprocedure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingProcedureRepository extends JpaRepository<BookingProcedure, Integer> {
  }