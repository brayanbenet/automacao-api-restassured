package client;

import data.factory.LoginDataFactory;
import dto.login.LoginResponse;
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
}
