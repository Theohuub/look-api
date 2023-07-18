package br.com.ifpe.look.modelo.loja;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.look.util.entity.GenericService;
import br.com.ifpe.look.util.exception.EntidadeNaoEncontradaException;

@Service
public class LojaService extends GenericService{

   @Autowired
   private LojaRepository repository;

   @Transactional
   public Loja save(Loja loja) {

       super.preencherCamposAuditoria(loja);
       return repository.save(loja);
   }

   @Transactional
   public void update(Long id, Loja lojaAlterado) {

      Loja loja = repository.findById(id).get();
      loja.setNomeLoja(lojaAlterado.getNomeLoja());
      loja.setEnderecoWeb(lojaAlterado.getEnderecoWeb());
      loja.setFoneCelular(lojaAlterado.getFoneCelular());
      loja.setFoneFixo(lojaAlterado.getFoneFixo());
      loja.setCidadeOrigem(lojaAlterado.getCidadeOrigem());
      loja.setCnpj(lojaAlterado.getCnpj());
      loja.setResponsavel(lojaAlterado.getResponsavel());
	    
      super.preencherCamposAuditoria(loja);
      repository.save(loja);
  }

   public List<Loja> listarTodos() {
  
    return repository.findAll();
}


public Loja obterPorID(Long id) {
    Optional<Loja> consulta = repository.findById(id);
  
       if (consulta.isPresent()) {
           return consulta.get();
       } else {
           throw new EntidadeNaoEncontradaException("Loja", id);
       }
       /**
        * return repository.findById(id).get(); 
        */
       
}

@Transactional
public void delete(Long id) {

    Loja loja = repository.findById(id).get();
    loja.setHabilitado(Boolean.FALSE);
    super.preencherCamposAuditoria(loja);

    repository.save(loja);
}

}
