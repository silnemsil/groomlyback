package ee.valiit.groomlyback.services;

import ee.valiit.groomlyback.RegistrationRequest;
import ee.valiit.groomlyback.RegistrationResponse;
import ee.valiit.groomlyback.persistence.role.RoleRepository;
import ee.valiit.groomlyback.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository; // meil on vaja teada, mis roll

    public RegistrationResponse register(RegistrationRequest request) {
        //TODO: User user = new user
        //TODO: set username
        // TODO: set password
        // TODO: set role
        //TODO: salvestamine

        //siia tuleb kood ↑↑↑ vastaval T_O_D_O korraldustele

        //TODO: tuleb sisse uus RegistrationResponse, sellega vaja miskit teha
        //TODO: set set set
        //TODO: mõistlik return

    }
}
