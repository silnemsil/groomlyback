package ee.valiit.groomlyback.persistence.bookingprocedure;

import ee.valiit.groomlyback.persistence.procedure.Procedure;
import ee.valiit.groomlyback.persistence.booking.Booking;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "booking_procedure", schema = "groomly")
public class BookingProcedure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "procedure_id", nullable = false)
    private Procedure procedure;

}