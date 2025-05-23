package ee.valiit.groomlyback.services;

import ee.valiit.groomlyback.RegistrationRequest;
import ee.valiit.groomlyback.controller.registration.dto.RegistrationResponse;
import ee.valiit.groomlyback.infrastructure.error.Error;
import ee.valiit.groomlyback.infrastructure.exception.ForbiddenException;
import ee.valiit.groomlyback.infrastructure.exception.ForeignKeyNotFoundException;
import ee.valiit.groomlyback.persistence.role.Role;
import ee.valiit.groomlyback.persistence.role.RoleRepository;
import ee.valiit.groomlyback.persistence.user.User;
import ee.valiit.groomlyback.persistence.user.UserMapper;
import ee.valiit.groomlyback.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository; // meil on vaja teada, mis roll
    private final UserMapper userMapper;


    public void register(RegistrationRequest request) {

        // todo: Kontrolli kas username on juba user tabalis kasutusel, kui jah siis viska vastav viga

//        if (?? true/false ??) {
//            throw new ForbiddenException(Error.USERNAME_UNAVAILABLE.getMessage(), Error.USERNAME_UNAVAILABLE.getErrorCode())
//        }

        Role role = roleRepository.findById(request.getRoleId())
                .orElseThrow(() -> new ForeignKeyNotFoundException("roleId", request.getRoleId()));

        User user = userMapper.toUser(request);
        user.setRole(role);
        userRepository.save(user);

    }
}
