package ee.valiit.groomlyback.controller.registration;

import ee.valiit.groomlyback.RegistrationRequest;
import ee.valiit.groomlyback.persistence.groomer.GroomerDto;
import ee.valiit.groomlyback.services.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequiredArgsConstructor

public class RegistrationController {

    private final RegistrationService registrationService;


    @PostMapping("/register-customer")
    //                                ↓ ÜMBRIKU TÜÜP     ↓ MUUTUJA NIMI
    public void registerCustomer(@RequestBody RegistrationRequest request) {
        registrationService.registerCustomer(request);
    }

//TODO: tee RegistrationServices korda:
    /*
    @PostMapping("/register-groomer")
    public void registerGroomer(@RequestBody GroomerDto dto) {
        registrationService.registerGroomer(dto);
    }
*/
}
