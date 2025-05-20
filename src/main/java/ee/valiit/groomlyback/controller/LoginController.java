package ee.valiit.groomlyback.controller;

import ee.valiit.groomlyback.LoginResponse;
import ee.valiit.groomlyback.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;


    @GetMapping("/login")
    public LoginResponse login(@RequestParam String username, @RequestParam String password) {
        LoginResponse loginResponse = loginService.login(username, password);
        return loginResponse;
    }

}