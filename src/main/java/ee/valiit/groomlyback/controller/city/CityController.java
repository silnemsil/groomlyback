package ee.valiit.groomlyback.controller.city;

import ee.valiit.groomlyback.controller.city.dto.CityDto;
import ee.valiit.groomlyback.services.city.CityService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @GetMapping("/cities")
    @Operation(
            summary = "Et leida meie andmebaasis linnad, mis on salvestatud",
            description = "Tagastab info koos cityId ja cityName'ga")
    public List<CityDto> getAllCities() {

        List<CityDto> cityDtos = cityService.getAllCities();
        return cityDtos;
    }

}


