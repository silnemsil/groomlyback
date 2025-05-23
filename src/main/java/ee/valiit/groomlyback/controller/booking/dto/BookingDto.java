package ee.valiit.groomlyback.controller.booking.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
    public class BookingDto {

        private Integer groomerId;
        private Integer customerUserId;
        private Integer procedureId;
        private String status;
        private BigDecimal totalPrice;
        private LocalDate date;
}
