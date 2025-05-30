package ee.valiit.groomlyback.controller.booking.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookingRequestDto {
    private Integer customerUserId;
    private Integer procedureId;
    private BigDecimal procedurePrice;
}
