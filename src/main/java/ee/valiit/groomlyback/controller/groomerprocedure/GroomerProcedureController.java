package ee.valiit.groomlyback.controller.groomerprocedure;

import ee.valiit.groomlyback.controller.groomerprocedure.dto.GroomerProcedureDto;
import ee.valiit.groomlyback.services.GroomerProcedureService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroomerProcedureController {
    private final GroomerProcedureService groomerProcedureService;

    public GroomerProcedureController (GroomerProcedureService groomerProcedureService) {
        this.groomerProcedureService = groomerProcedureService;
    }
    @GetMapping("/groomer-procedures")
    public List<GroomerProcedureDto> getProcedures(@RequestParam Integer groomerId) {
        return groomerProcedureService.getGroomerProcedures(groomerId);
    }
}
