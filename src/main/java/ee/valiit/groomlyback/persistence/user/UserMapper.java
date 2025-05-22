package ee.valiit.groomlyback.persistence.user;

import ee.valiit.groomlyback.controller.login.dto.LoginResponse;

public interface UserMapper {
    LoginResponse toLoginResponse(User user);
}
