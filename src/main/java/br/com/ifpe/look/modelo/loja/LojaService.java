package br.com.ifpe.look.modelo.loja;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ifpe.look.util.entity.GenericService;

public class LojaService extends GenericService{
    
    @Autowired
    private LojaRepository repository;
 
    @Transactional
    public Loja save(Loja loja) {
 
        super.preencherCamposAuditoria(loja);
        return repository.save(loja);
    }

    public List<Loja> listarTodos() {
  
    return repository.findAll();
}

    public Loja obterPorID(Long id) {

    return repository.findById(id).get();
}
}
