package ee.valiit.groomlyback.services;

import ee.valiit.groomlyback.NewCustomer;
import ee.valiit.groomlyback.infrastructure.error.Error;
import ee.valiit.groomlyback.infrastructure.exception.ForbiddenException;
import ee.valiit.groomlyback.infrastructure.exception.ForeignKeyNotFoundException;
import ee.valiit.groomlyback.persistence.groomer.Groomer;
import ee.valiit.groomlyback.controller.registration.dto.NewGroomer;
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

    public static final int ROLE_GROOMER = 2;
    public static final int ROLE_CUSTOMER = 3;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;
    private final GroomerRepository groomerRepository;
    private final GroomerMapper groomerMapper;





    public void registerCustomer(NewCustomer newCustomer) {

        if (userRepository.findByUsername(newCustomer.getUsername()).isPresent()) {
            throw new ForbiddenException(Error.USERNAME_UNAVAILABLE.getMessage(), Error.USERNAME_UNAVAILABLE.getErrorCode());
        }

        Role role = roleRepository.findById(ROLE_CUSTOMER).get();

        User user = userMapper.toUser(newCustomer);
        user.setRole(role);
        userRepository.save(user);

    }

    public void registerGroomer(NewGroomer newGroomer) {
        if (userRepository.findByUsername(newGroomer.getGroomerEmail()).isPresent()) {
            throw new ForbiddenException(Error.USERNAME_UNAVAILABLE.getMessage(), Error.USERNAME_UNAVAILABLE.getErrorCode());
        }

        Role role = roleRepository.findById(ROLE_GROOMER).get();

        User user = userMapper.toUser(newGroomer);
        user.setRole(role);
        userRepository.save(user);

        Location location = locationMapper.toLocation(newGroomer);
        locationRepository.save(location);

        Groomer groomer = groomerMapper.toGroomer(newGroomer);
        groomer.setUser(user);
        groomer.setLocation(location);
        groomerRepository.save(groomer);
    }

}
