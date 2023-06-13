package br.com.ifpe.look.modelo.loja;

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
@Table(name = "Loja")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Loja extends EntidadeAuditavel{
    
    @Column
    private String nomeLoja;

    @Column
    private String endereco;
 
    @Column
    private String foneCelular;

    @Column
    private String foneFixo;

    @Column
    private String cidadeOrigem;

    @Column
    private String cnpj;
}
