package br.com.ifpe.look.api.loja;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import br.com.ifpe.look.modelo.loja.Loja;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LojaRequest {
   
   @NotNull(message = "O Nome loja é de preenchimento obrigatório")
   @NotBlank(message = "O Nome loja é de preenchimento obrigatório")
   @Length(max = 100, message = "O nome devera ter no max 100 caracteres")
   private String nomeLoja;

   @NotBlank(message =  "O endereço web da loja é obrigatório")
   @Length(max = 100, message = "O endereço ter")
   private String enderecoWeb;

   private String foneCelular;

   
   @NotBlank(message = "Telefone fixo obrigatório")
   @Length(min = 8, max = 20, message = "O campo fone tem que ter de 8 a 20 caracteres")
   private String foneFixo;

   @NotNull
   @NotBlank(message = "Prennchimento Da Cidade de origem obrigatório")
   private String cidadeOrigem;

   @NotNull(message = "Cnpj obrigatório")
   @NotBlank(message = "Cnpj obrigatório")
   @CNPJ
   private String cnpj;

   @NotNull(message = "O nome do responsavel é obrigatório")
   @NotBlank(message = "O Nome é do responsavel é preenchimento obrigatório")
   private String responsavel;

   public Loja build() {

       return Loja.builder()
               .nomeLoja(nomeLoja)
               .enderecoWeb(enderecoWeb)
               .foneCelular(foneCelular)
               .foneFixo(foneFixo)
               .cidadeOrigem(cidadeOrigem)
               .cnpj(cnpj)
               .responsavel(responsavel)
               .build();
   }
}