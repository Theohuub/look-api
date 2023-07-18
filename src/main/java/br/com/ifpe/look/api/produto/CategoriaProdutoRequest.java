package br.com.ifpe.look.api.produto;

import javax.validation.constraints.NotBlank;

import br.com.ifpe.look.modelo.produto.CategoriaProduto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaProdutoRequest {

    @NotBlank(message = "A Descrição é de preenchimento obrigatório")
   private String descricao;

   public CategoriaProduto build() {

       return CategoriaProduto.builder()
               .descricao(descricao)
               .build();
   }
}