package ee.valiit.groomlyback.persistence.user;

import ee.valiit.groomlyback.controller.login.dto.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImplementation implements UserMapper {

    @Override
    public LoginResponse toLoginResponse(User user) {
        if (user == null) {
            return null;
        }

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUserId(user.getId());
        loginResponse.setRoleName(user.getRole().getName());

        return loginResponse;
    }
}
