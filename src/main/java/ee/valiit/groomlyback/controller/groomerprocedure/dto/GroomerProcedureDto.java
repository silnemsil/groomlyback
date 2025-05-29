package ee.valiit.groomlyback.controller.groomerprocedure.dto;

import ee.valiit.groomlyback.persistence.groomerprocedure.GroomerProcedure;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link GroomerProcedure}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroomerProcedureDto implements Serializable {
    private Integer id;
    @NotNull
    private GroomerProcedureDto groomerprocedure;
    @NotNull
    private GroomerProcedureDto procedure;
    @NotNull
    private BigDecimal price;
}