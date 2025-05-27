package ee.valiit.groomlyback.controller.registration.dto;

import ee.valiit.groomlyback.NewCustomer;
import ee.valiit.groomlyback.persistence.groomer.Groomer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class NewGroomer extends NewCustomer implements Serializable {
    private Integer cityId;
    private String streetName;
    private String houseNumber;
    private String groomerName;
    private String groomerDescription;
    private String groomerTelNumber;
    private String groomerEmail;
}