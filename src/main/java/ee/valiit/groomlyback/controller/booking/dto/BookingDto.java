package ee.valiit.groomlyback.controller.booking.dto;

import ee.valiit.groomlyback.persistence.user.User;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class BookingDto  {
// ainult Id-d
    private Integer id;
    private Integer groomerId;
    private Integer customerUserId;
    private char status;
    private BigDecimal totalPrice;
    private LocalDate date;
    private Integer procedureId;



}
