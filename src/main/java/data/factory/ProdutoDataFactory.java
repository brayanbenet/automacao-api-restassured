package data.factory;

import dto.produto.ProdutoRequest;
import net.datafaker.Faker;

import java.util.Locale;

public class ProdutoDataFactory {
    private static Faker faker = new Faker(new Locale("PT-BR"));

    public static ProdutoRequest produtoValido() {

        ProdutoRequest produtoRequest = new ProdutoRequest();

        produtoRequest.setNome(faker.name().firstName());
        produtoRequest.setPreco(faker.number().numberBetween(10, 1000));
        produtoRequest.setDescricao(faker.lorem().sentence());
        produtoRequest.setQuantidade(faker.number().numberBetween(5, 400));

        return produtoRequest;
    }
}
