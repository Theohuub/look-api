package br.com.ifpe.look.modelo.produto;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.look.util.entity.GenericService;


@Service
public class ProdutoService extends GenericService{
    
    @Autowired
    private ProdutoRepository repository;
 
    @Transactional
    public Produto save(Produto produto) {
 
        super.preencherCamposAuditoria(produto);
        return repository.save(produto);
    }

    public List<Produto> listarTodos() {
  
    return repository.findAll();
}

    public Produto obterPorID(Long id) {

    return repository.findById(id).get();
}
}
