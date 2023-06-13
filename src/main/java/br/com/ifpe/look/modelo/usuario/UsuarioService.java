package br.com.ifpe.look.modelo.usuario;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.look.util.entity.GenericService;

@Service
public class UsuarioService extends GenericService {

    @Autowired
    private UsuarioRepository repository;

    @Transactional
    public Usuario save(Usuario usuario) {

        super.preencherCamposAuditoria(usuario);
        return repository.save(usuario);
    }

    @Transactional
    public void update(Long id, Usuario usuarioAlterado) {

        Usuario usuario = repository.findById(id).get();
        usuario.setNome(usuarioAlterado.getNome());
        usuario.setCpf(usuarioAlterado.getCpf());
        usuario.setDataNascimento(usuarioAlterado.getDataNascimento());
        usuario.setEmail(usuarioAlterado.getEmail());
        usuario.setFoneCelular(usuarioAlterado.getFoneCelular());
        usuario.setFoneFixo(usuarioAlterado.getFoneFixo());
        usuario.setSenha(usuarioAlterado.getSenha());

        super.preencherCamposAuditoria(usuario);
        repository.save(usuario);
    }

    public List<Usuario> listarTodos() {

        return repository.findAll();
    }

    public Usuario obterPorID(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public void delete(Long id) {

        Usuario usuario = repository.findById(id).get();
        usuario.setHabilitado(Boolean.FALSE);
        super.preencherCamposAuditoria(usuario);

        repository.save(usuario);
    }

}
