package ee.valiit.groomlyback.persistence.user;

import ee.valiit.groomlyback.LoginResponse;

public interface UserMapper {
    LoginResponse toLoginResponse(User user);
}
