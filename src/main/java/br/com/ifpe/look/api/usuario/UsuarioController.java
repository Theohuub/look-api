package br.com.ifpe.look.api.usuario;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.look.modelo.usuario.Usuario;
import br.com.ifpe.look.modelo.usuario.UsuarioService;
import br.com.ifpe.look.util.entity.GenericController;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController extends GenericController {

   @Autowired
   private UsuarioService usuarioService;

   @PostMapping
   public ResponseEntity<Usuario> save(@RequestBody @Valid UsuarioRequest request) {

      Usuario usuarioNovo = request.build();
      Usuario usuario = usuarioService.save(usuarioNovo);
      return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
   }

   @GetMapping
   public List<Usuario> listarTodos() {

      return usuarioService.listarTodos();
   }

   @GetMapping("/{id}")
   public Usuario obterPorID(@PathVariable Long id) {

      return usuarioService.obterPorID(id);
   }

   @PutMapping("/{id}")
   public ResponseEntity<Usuario> update(@PathVariable("id") Long id, @RequestBody UsuarioRequest request) {

      usuarioService.update(id, request.build());
      return ResponseEntity.ok().build();
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

      usuarioService.delete(id);
      return ResponseEntity.ok().build();
   }

}