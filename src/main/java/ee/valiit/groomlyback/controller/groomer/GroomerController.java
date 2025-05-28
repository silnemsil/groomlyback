package ee.valiit.groomlyback.controller.groomer;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GroomerController {

    private final GroomerService groomerService;
    @GetMapping("cities/groomers")





}
