package ee.valiit.groomlyback.controller.registration;

import ee.valiit.groomlyback.RegistrationRequest;
import ee.valiit.groomlyback.controller.registration.dto.RegistrationResponse;
import ee.valiit.groomlyback.services.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class RegistrationController {

    private final RegistrationService registrationService;


    @PostMapping("/register")
    //  selle anndotatsioonis asin GPTlt ↓↓↓          ↓↓↓ ÜMBRIKU TÜÜP   ↓ MUUTUJA NIMI
    public RegistrationResponse register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }
}
