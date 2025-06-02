package ee.valiit.groomlyback.controller.booking.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookingRequest {
    private Integer customerUserId;
    private Integer groomerProcedureId;
    private BigDecimal procedurePrice;
}
