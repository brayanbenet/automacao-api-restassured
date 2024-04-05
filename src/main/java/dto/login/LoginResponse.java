package dto.login;

import lombok.Data;

@Data
public class LoginResponse {

    private String message;
    private String authorization;
}
