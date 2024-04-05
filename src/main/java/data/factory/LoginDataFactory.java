package data.factory;

import dto.login.LoginRequest;

public class LoginDataFactory {

    public static LoginRequest loginValido() {

        LoginRequest loginValido = new LoginRequest();
        loginValido.setEmail("admin@admin.com.br");
        loginValido.setPassword("admin");

        return loginValido;
    }
}
