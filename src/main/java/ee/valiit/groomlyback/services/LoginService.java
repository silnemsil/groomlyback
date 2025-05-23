package ee.valiit.groomlyback.services;


import ee.valiit.groomlyback.controller.login.dto.LoginResponse;
import ee.valiit.groomlyback.infrastructure.exception.ForbiddenException;
import ee.valiit.groomlyback.persistence.user.User;
import ee.valiit.groomlyback.persistence.user.UserMapper;
import ee.valiit.groomlyback.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import static ee.valiit.groomlyback.Status.ACTIVE;
import static ee.valiit.groomlyback.infrastructure.error.Error.INCORRECT_CREDENTIALS;

//TODO: Korralikud kontrollid
//TODO: Kas kasutaja on olemas? Ega pole tühi jne



@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    //otsi välja entity, tee dto'ks
    public LoginResponse login(String username, String password) {
        //↓ TÜÜP↓ ÜMBRIKU NIMI
        User user = userRepository.findUserBy(username, password, ACTIVE.getCode())//anna andmebaasist,
                .orElseThrow(()-> new ForbiddenException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode())); // või VISKA VIGA

        //↓↓↓ TÜÜP    ↓↓↓ ÜMBRIKU NIMI  ↓↓↓ ÜMBRIKU NIMI  ↓↓↓ meetod mida käivitada
        LoginResponse loginResponse = userMapper.toLoginResponse(user);

        return loginResponse;

    }
}
