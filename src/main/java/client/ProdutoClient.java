package client;

import dto.produto.ProdutoRequest;
import io.restassured.response.Response;
import specs.ProdutoSpecs;

import static io.restassured.RestAssured.*;

public class ProdutoClient {

    private static final String CADASTRAR = "/produtos";
    private static final String DELETAR = "/produtos/{_id}";
    private static final String BUSCAR_POR_ID = "/produtos/{_id}";

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

    public Response deletarProduto(String id) {
        return
                given()
                    .spec(ProdutoSpecs.produtoReqSpec())
                    .pathParam("_id", id)
                .when()
                    .delete(DELETAR)
                ;
    }

    public Response buscarProdutoPorId(String id) {

        return
                given()
                    .spec(ProdutoSpecs.produtoReqSpec())
                    .pathParam("_id", id)
                .when()
                    .get(BUSCAR_POR_ID)
                ;
    }

}
