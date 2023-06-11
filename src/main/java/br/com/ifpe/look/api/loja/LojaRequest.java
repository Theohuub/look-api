package br.com.ifpe.look.api.loja;

import br.com.ifpe.look.modelo.loja.Loja;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LojaRequest {
   
   private String nomeLoja;

   private String enderecoWeb;

   private String foneCelular;

   private String foneFixo;

   private String cidadeOrigem;

   private String cnpj;

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