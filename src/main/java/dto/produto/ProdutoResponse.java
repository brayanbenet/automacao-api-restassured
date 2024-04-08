package dto.produto;

import lombok.Data;

@Data
public class ProdutoResponse extends ProdutoRequest{

    private String message;
    private String _id;
}
