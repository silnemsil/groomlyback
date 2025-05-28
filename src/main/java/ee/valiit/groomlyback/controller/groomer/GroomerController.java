package ee.valiit.groomlyback.controller.groomer;

import ee.valiit.groomlyback.controller.groomer.dto.GroomerDto;


import ee.valiit.groomlyback.services.GroomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroomerController {

    private final GroomerService groomerService;


    public GroomerController(GroomerService groomerService) {
        this.groomerService = groomerService;
    }


    @GetMapping("/groomers")
    public List<GroomerDto> getAllGroomers() {
        return groomerService.getAllGroomers();
    }

    @GetMapping("/groomer")
    public GroomerDto getGroomerDetails(@RequestParam Integer groomerId) {
        return groomerService.getGroomerDetails(groomerId);
    }
}
