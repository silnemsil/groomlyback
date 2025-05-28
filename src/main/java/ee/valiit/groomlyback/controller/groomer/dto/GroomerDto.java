package ee.valiit.groomlyback.controller.groomer.dto;

import ee.valiit.groomlyback.persistence.groomer.Groomer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Groomer}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroomerDto implements Serializable {
    private Integer cityId;
    private String streetName;
    private String houseNumber;
    private String groomerName;
    private String groomerDescription;
    private String groomerTelNumber;
    private String groomerEmail;
}