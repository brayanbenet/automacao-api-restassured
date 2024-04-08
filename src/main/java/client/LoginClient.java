package client;

import data.factory.LoginDataFactory;
import dto.login.LoginRequest;
import dto.login.LoginResponse;
import io.restassured.response.Response;
import specs.LoginSpecs;
import static data.factory.LoginDataFactory.loginValido;
import static io.restassured.RestAssured.*;

public class LoginClient {

    private static final String LOGIN = "/login";

    private static String tokenValido;

    public static String tokenValido() {
        LoginDataFactory loginValido = new LoginDataFactory();

        LoginResponse response =
                given()
                        .spec(LoginSpecs.loginResSpec())
                        .body(loginValido())
                        .when()
                        .post(LOGIN)
                        .then()
                        .extract().as(LoginResponse.class)
                ;

        tokenValido = response.getAuthorization();
        return tokenValido;
    }

    public Response logar() {
        return
        given()
                .spec(LoginSpecs.loginResSpec())
                .body(loginValido())
                .when()
                .post(LOGIN)
                ;
    }
}
