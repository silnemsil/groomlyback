package ee.valiit.groomlyback;


import lombok.Data;

@Data
public class LoginResponse {
    private Integer userId;
    private String roleName;
}
