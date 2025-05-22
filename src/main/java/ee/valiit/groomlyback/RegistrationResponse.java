package ee.valiit.groomlyback;

import lombok.Data;

@Data
public class RegistrationResponse {
    private Integer userId;
    private String message;
}