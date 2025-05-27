package ee.valiit.groomlyback.services;

import ee.valiit.groomlyback.RegistrationRequest;
import ee.valiit.groomlyback.infrastructure.error.Error;
import ee.valiit.groomlyback.infrastructure.exception.ForbiddenException;
import ee.valiit.groomlyback.infrastructure.exception.ForeignKeyNotFoundException;
import ee.valiit.groomlyback.persistence.groomer.Groomer;
import ee.valiit.groomlyback.persistence.groomer.GroomerDto;
import ee.valiit.groomlyback.persistence.groomer.GroomerMapper;
import ee.valiit.groomlyback.persistence.groomer.GroomerRepository;
import ee.valiit.groomlyback.persistence.location.Location;
import ee.valiit.groomlyback.persistence.location.LocationMapper;
import ee.valiit.groomlyback.persistence.location.LocationRepository;
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
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;
    private final GroomerRepository groomerRepository;
    private final GroomerMapper groomerMapper;





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

    public void registerGroomer(GroomerDto groomerDto) {
        if (userRepository.findByUsername(groomerDto.getGroomerEmail()).isPresent()) {
            throw new ForbiddenException(Error.USERNAME_UNAVAILABLE.getMessage(), Error.USERNAME_UNAVAILABLE.getErrorCode());
        }

        Role role = roleRepository.findById(2) //
                .orElseThrow(() -> new ForeignKeyNotFoundException("roleId", 2));

        User user = userMapper.toUser(groomerDto);
        user.setRole(role);
        userRepository.save(user);

        Location location = locationMapper.toLocation(groomerDto);
        locationRepository.save(location);

        Groomer groomer = groomerMapper.toGroomer(groomerDto);
        groomer.setUser(user);
        groomer.setLocation(location);
        groomerRepository.save(groomer);
    }

}
