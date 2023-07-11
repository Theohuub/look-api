package br.com.ifpe.look.modelo.usuario;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import br.com.ifpe.look.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Usuario")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends EntidadeAuditavel  {

    @Column
    private String nome;
    
    @Column
    private String cpf;

    @Column
    private LocalDate dataNascimento;

    @Column
    private String email;

    @Column
    private String foneCelular;

    @Column
    private String foneFixo;

    @Column
    private String senha;

}