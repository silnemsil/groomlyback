package ee.valiit.groomlyback.persistence.groomerprocedure;

import ee.valiit.groomlyback.persistence.procedure.Procedure;
import ee.valiit.groomlyback.persistence.groomer.Groomer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "groomer_procedure", schema = "groomly")
public class GroomerProcedure {
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
    @JoinColumn(name = "procedure_id", nullable = false)
    private Procedure procedure;

    @NotNull
    @Column(name = "price", nullable = false, precision = 5, scale = 2)
    private BigDecimal price;

}
