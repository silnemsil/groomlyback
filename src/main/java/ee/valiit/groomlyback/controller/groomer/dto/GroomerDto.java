package ee.valiit.groomlyback.controller.groomer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroomerDto implements Serializable {
    private Integer groomerId;
    private Integer cityId;
    private String groomerName;
    private String groomerDescription;
    private String groomerTelNumber;
    private String groomerEmail;
    private String streetName;
    private String houseNumber;
    private List<ProcedureInfo> procedures;
}
