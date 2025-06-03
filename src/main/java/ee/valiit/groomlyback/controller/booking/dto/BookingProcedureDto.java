package ee.valiit.groomlyback.controller.booking.dto;

import ee.valiit.groomlyback.persistence.bookingprocedure.BookingProcedure;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link BookingProcedure}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingProcedureDto implements Serializable {
    private Integer bookingProcedureId;
    private String procedureName;
    private String procedureDescription;
    private BigDecimal price;
}