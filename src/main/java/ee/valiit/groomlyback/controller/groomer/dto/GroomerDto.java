package ee.valiit.groomlyback.controller.groomer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroomerDto implements Serializable {
    private Integer id;  // groomeri ID, kasulik response'is
    private Integer cityId;
    private String groomerName;
    private String groomerDescription;
    private String groomerTelNumber;
    private String groomerEmail;
    private String streetName;   // kui soovid ka aadressi infot edasi anda
    private String houseNumber;  // sama siin
}
