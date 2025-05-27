package ee.valiit.groomlyback.persistence.location;

import ee.valiit.groomlyback.controller.city.dto.CityDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Location}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto implements Serializable {
    private Integer id;
    @NotNull
    private CityDto city;
    @NotNull
    @Size(max = 255)
    private String streetName;
    @Size(max = 255)
    private String houseNumber;
}