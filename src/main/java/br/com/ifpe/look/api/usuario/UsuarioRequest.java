package br.com.ifpe.look.api.usuario;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.look.modelo.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {

    private String nome;
    
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String email;

    private String foneCelular;

    private String foneFixo;

    private String senha;

    public Usuario build() {
        
        return Usuario.builder()
        .nome(nome)
        .cpf(cpf)
        .dataNascimento(dataNascimento)
        .email(email)
        .foneCelular(foneCelular)
        .foneFixo(foneFixo)
        .senha(senha)
        .build();
    }

}