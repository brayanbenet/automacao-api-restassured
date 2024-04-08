package funcional;

import client.ProdutoClient;
import data.factory.ProdutoDataFactory;
import dto.produto.ProdutoRequest;
import dto.produto.ProdutoResponse;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoFuncionalTest {

    ProdutoClient produtoClient = new ProdutoClient();

    @Test
    public void testCadastrarProdutoComSucesso() {

        ProdutoRequest produtoCriado = ProdutoDataFactory.produtoValido();

        ProdutoResponse response = produtoClient.cadastrarProduto(produtoCriado)
                .then()
                    .statusCode(201)
                    .extract().as(ProdutoResponse.class)
                ;

        assertAll("Produto Response",
                () -> assertEquals("Cadastro realizado com sucesso", response.getMessage()),
                () -> assertNotNull(response.get_id())
        );

        produtoClient.deletarProduto(response.get_id());
    }

    @Test
    public void testBuscarProdutoPorIdComSucesso() {

        ProdutoRequest produto = ProdutoDataFactory.produtoValido();

        ProdutoResponse produtoCriado = produtoClient.cadastrarProduto(produto).as(ProdutoResponse.class);

        ProdutoResponse response = produtoClient.buscarProdutoPorId(produtoCriado.get_id())
                        .then()
                            .statusCode(200)
                            .extract().as(ProdutoResponse.class)
                        ;
        assertAll("Produto Response",
                () -> assertEquals(produtoCriado.get_id(), response.get_id())
        );

        produtoClient.deletarProduto(produtoCriado.get_id());
    }


}
