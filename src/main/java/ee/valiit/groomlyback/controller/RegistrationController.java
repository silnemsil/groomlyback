package ee.valiit.groomlyback.controller;

import ee.valiit.groomlyback.RegistrationRequest;
import ee.valiit.groomlyback.RegistrationResponse;
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
    //                                  ↓ Mis ANNOTATSIOON?                                     ↓↓↓ ÜMBRIKU TÜÜP   ↓ MUUTUJA NIMI
    public RegistrationResponse register(/*slle annatoatsiooni küsisin chatGPT-lt*/@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }
}
