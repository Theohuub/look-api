package br.com.ifpe.look.api.produto;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.look.modelo.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

    private Long idCategoria;
    
    @NotBlank(message = "O titulo é de preenchimento obrigatório")
    private String titulo;

    @NotBlank(message = "O codigo é de preenchimento obrigatório")
    private String codigo;
    
    @NotBlank(message = "A descrição é de preenchimento obrigatório")
    private String descricao;

    @NotBlank(message = "O Valor é de preenchimento obrigatório")
    private Double valorUnitario;
    
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeVencimento;

    public Produto build() {

        return Produto.builder()
                .titulo(titulo)
                .codigo(codigo)
                .descricao(descricao)
                .valorUnitario(valorUnitario)
                .dataDeVencimento(dataDeVencimento)
                .build();
    }
 
}
