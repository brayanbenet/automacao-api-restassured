package specs;

import client.LoginClient;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ProdutoSpecs {

    private ProdutoSpecs(){}

    public static RequestSpecification produtoReqSpec() {

        LoginClient loginClient = new LoginClient();

        return new RequestSpecBuilder()
                .addRequestSpecification(InicialSpecs.setUp())
                .setContentType(ContentType.JSON)
                .addHeader("authorization", loginClient.tokenValido())
                .build();
    }
}
