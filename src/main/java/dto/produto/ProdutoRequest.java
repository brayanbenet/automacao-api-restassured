package dto.produto;

import lombok.Data;

@Data
public class ProdutoRequest {

    private String nome;
    private int preco;
    private String descricao;
    private int quantidade;
}
