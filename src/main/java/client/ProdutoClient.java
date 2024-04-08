package client;

import dto.produto.ProdutoRequest;
import io.restassured.response.Response;
import specs.ProdutoSpecs;

import static io.restassured.RestAssured.*;

public class ProdutoClient {

    private static final String CADASTRAR = "/produtos";

    public ProdutoClient(){}

    public Response cadastrarProduto(ProdutoRequest produto) {
        return
                given()
                    .spec(ProdutoSpecs.produtoReqSpec())
                    .body(produto)
                .when()
                    .post(CADASTRAR)
                ;
    }

}
