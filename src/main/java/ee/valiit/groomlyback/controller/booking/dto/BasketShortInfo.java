package ee.valiit.groomlyback.controller.booking.dto;

import lombok.Data;

@Data
public class BasketShortInfo {
    private Boolean isBookingStarted;
    private Integer bookingId;
    private Long numberOfItems;
}
