package ee.valiit.groomlyback.services;

import ee.valiit.groomlyback.RegistrationRequest;
import ee.valiit.groomlyback.infrastructure.error.Error;
import ee.valiit.groomlyback.infrastructure.exception.ForbiddenException;
import ee.valiit.groomlyback.infrastructure.exception.ForeignKeyNotFoundException;
import ee.valiit.groomlyback.persistence.groomer.GroomerDto;
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


    public void registerCustomer(RegistrationRequest request) {

        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new ForbiddenException(Error.USERNAME_UNAVAILABLE.getMessage(), Error.USERNAME_UNAVAILABLE.getErrorCode());
        }

        Role role = roleRepository.findById(request.getRoleId())
                .orElseThrow(() -> new ForeignKeyNotFoundException("roleId", request.getRoleId()));

        User user = userMapper.toUser(request);
        user.setRole(role);
        userRepository.save(user);

    }
    //TODO: see on GPT pakutu, tuleb teha ümber kasutades meie konvektsiooni
/*
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    private final GroomerRepository groomerRepository;
    private final RoleRepository roleRepository;

    public void registerGroomer(GroomerDto dto) {
        // 1. Loo User (groomer peab olema ka kasutaja)
        User user = new User();
        user.setEmail(dto.getGroomerEmail());
        user.setTelNumber(dto.getGroomerTelNumber());
        user.setActive(true);

        // RoleId peaks olema 2 (GROOMER)
        Role groomerRole = roleRepository.findById(2)
                .orElseThrow(() -> new IllegalArgumentException("Role not found: 2"));
        user.setRole(groomerRole);

        userRepository.save(user);

        // 2. Loo Location
        Location location = new Location();
        location.setCityId(dto.getCityId());
        location.setStreetName(dto.getStreetName());
        location.setHouseNumber(dto.getHouseNumber());

        locationRepository.save(location);

        // 3. Loo Groomer
        Groomer groomer = new Groomer();
        groomer.setUser(user);
        groomer.setLocation(location);
        groomer.setName(dto.getGroomerName());
        groomer.setDescription(dto.getGroomerDescription());
        groomer.setTelNumber(dto.getGroomerTelNumber());
        groomer.setEmail(dto.getGroomerEmail());

        groomerRepository.save(groomer);
    }


    public void registerGroomer(GroomerDto dto) {
    }*/
}
