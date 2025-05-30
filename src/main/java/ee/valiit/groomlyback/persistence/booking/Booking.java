package ee.valiit.groomlyback.persistence.booking;

import ee.valiit.groomlyback.persistence.groomer.Groomer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "booking")
@Getter
@Setter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "groomer_id")
    private Groomer groomer;

    @Column(name = "customer_user_id")
    private Integer customerUserId;

    private String status;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    private LocalDate date;
}
