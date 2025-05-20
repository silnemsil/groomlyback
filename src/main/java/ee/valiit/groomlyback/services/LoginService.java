package ee.valiit.groomlyback.services;


import ee.valiit.groomlyback.LoginResponse;
import ee.valiit.groomlyback.persistence.user.User;
import ee.valiit.groomlyback.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static ee.valiit.groomlyback.Status.ACTIVE;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;


    public LoginResponse login(String username, String password) {
        User user = userRepository.findUserBy(username, password, ACTIVE.getCode());

        LoginResponse loginResponse = toLoginResponse(user);

        return loginResponse;
    }

    private static LoginResponse toLoginResponse(User user) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUserId(user.getId());
        loginResponse.setRoleName(user.getRole().getName());
        return loginResponse;
    }

}
