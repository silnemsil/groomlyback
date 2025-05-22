package ee.valiit.groomlyback.controller.booking.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BookingDto {

    private Integer id;
    private Integer groomerId;
    private Integer customerUserId;
    private char status;
    private BigDecimal totalPrice;
    private LocalDate date;
    private Integer procedureId;


}
