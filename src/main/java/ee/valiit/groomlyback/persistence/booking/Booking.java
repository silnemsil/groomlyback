package ee.valiit.groomlyback.persistence.booking;

import ee.valiit.groomlyback.persistence.groomer.Groomer;
import ee.valiit.groomlyback.persistence.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "booking", schema = "groomly")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "groomer_id", nullable = false)
    private Groomer groomer;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_user_id", nullable = false)
    private User customerUser;

    @NotNull
    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

    @NotNull
    @Column(name = "total_price", nullable = false, precision = 6, scale = 2)
    private BigDecimal totalPrice;

    @NotNull
    @Column(name = "date", nullable = false)
    private LocalDate date;

}