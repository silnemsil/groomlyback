package ee.valiit.groomlyback.controller.groomer;

import ee.valiit.groomlyback.controller.groomer.dto.GroomerDto;
import ee.valiit.groomlyback.services.GroomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GroomerController {

    private final GroomerService groomerService;

    @GetMapping("/groomers")
    public List<GroomerDto> getAllGroomers() {
        return groomerService.getAllGroomers();
    }

    @GetMapping("/city/groomers")
    public List<GroomerDto> getGroomersByCity(@RequestParam Integer cityId) {
        return groomerService.findGroomers(cityId);
    }

    @GetMapping("/groomer")
    public GroomerDto getGroomerDetails(@RequestParam Integer groomerId) {
        return groomerService.getGroomerDetails(groomerId);
    }


}
