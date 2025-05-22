package ee.valiit.groomlyback;

import lombok.Data;
@Data
public class RegistrationRequest {
    private String username;
    private String password;
    private Integer roleId;

}
