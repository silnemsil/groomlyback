package ee.valiit.groomlyback.controller.registration;

import ee.valiit.groomlyback.RegistrationRequest;
import ee.valiit.groomlyback.persistence.groomer.GroomerDto;
import ee.valiit.groomlyback.services.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;


    @PostMapping("/register-customer")
    public void registerCustomer(@RequestBody RegistrationRequest request) {
        registrationService.registerCustomer(request);
    }


    @PostMapping("/register-groomer")
    public void registerGroomer(@RequestBody GroomerDto groomerDto) {
        registrationService.registerGroomer(groomerDto);
    }

}
