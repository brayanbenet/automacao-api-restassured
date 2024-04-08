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
    public void testCadastrarProduto() {

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
    }

}
