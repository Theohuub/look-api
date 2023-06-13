package br.com.ifpe.look.api.loja;

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

import br.com.ifpe.look.modelo.loja.Loja;
import br.com.ifpe.look.modelo.loja.LojaService;
import br.com.ifpe.look.util.entity.GenericController;

@RestController
@RequestMapping("/api/loja")
public class LojaController extends GenericController {

   @Autowired
   private LojaService lojaService;

   @PostMapping
   public ResponseEntity<Loja> save(@RequestBody @Valid LojaRequest request) {

      Loja lojaNovo = request.build();
      Loja loja = lojaService.save(lojaNovo);
      return new ResponseEntity<Loja>(loja, HttpStatus.CREATED);
   }
   
   @GetMapping
   public List<Loja> listarTodos() {
  
       return lojaService.listarTodos();
   }

   @GetMapping("/{id}")
   public Loja obterPorID(@PathVariable Long id) {

       return lojaService.obterPorID(id);
   }
   
   @PutMapping("/{id}")
   public ResponseEntity<Loja> update(@PathVariable("id") Long id, @RequestBody LojaRequest request) {

       lojaService.update(id, request.build());
       return ResponseEntity.ok().build();
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

       lojaService.delete(id);
       return ResponseEntity.ok().build();
   }

}
