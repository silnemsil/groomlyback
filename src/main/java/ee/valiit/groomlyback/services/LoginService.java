package ee.valiit.groomlyback.services;


import ee.valiit.groomlyback.LoginResponse;
import ee.valiit.groomlyback.persistence.user.UserMapperImplementation;
import ee.valiit.groomlyback.infrastructure.exception.ForbiddenException;
import ee.valiit.groomlyback.persistence.user.User;
import ee.valiit.groomlyback.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static ee.valiit.groomlyback.Status.ACTIVE;
import static ee.valiit.groomlyback.infrastructure.error.Error.INCORRECT_CREDENTIALS;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final UserMapperImplementation userMapperImplementation;

    //otsi välja entity, tee dto'ks
    public LoginResponse login(String username, String password) {

        User user = userRepository.findUserBy(username, password, ACTIVE.getCode()).orElseThrow(()-> //anna andmebaasist, või VISKA VIGA
            new ForbiddenException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode()));

        //↓↓↓ TÜÜP    ↓↓↓ ÜMBRIKU NIMI
        LoginResponse loginResponse = userMapperImplementation.toLoginResponse(user);//
        return loginResponse;

    }
}
