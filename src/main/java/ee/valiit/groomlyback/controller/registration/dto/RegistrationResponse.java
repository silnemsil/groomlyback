package ee.valiit.groomlyback.controller.registration.dto;

import lombok.Data;

@Data
public class RegistrationResponse {
    private Integer userId;
    private String message;
}