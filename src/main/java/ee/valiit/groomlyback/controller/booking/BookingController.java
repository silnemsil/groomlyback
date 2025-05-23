package ee.valiit.groomlyback.controller.booking;

import ee.valiit.groomlyback.controller.booking.dto.BookingDto;
import ee.valiit.groomlyback.services.BookingService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookingController {

private final BookingService bookingService;


}
