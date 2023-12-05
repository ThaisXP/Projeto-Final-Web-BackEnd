package br.com.fatec.projetofinal.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fatec.projetofinal.entities.Pessoa;
import br.com.fatec.projetofinal.service.PessoaService;

@RestController
@RequestMapping("pessoas")
@CrossOrigin
public class PessoaController {
    
    @Autowired
    private PessoaService service;

    @GetMapping()
    public ResponseEntity<List<Pessoa>> getPessoas() {
        return ResponseEntity.ok(service.getPessoas());
    }

    @GetMapping("{id}")
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable int id) {
        return ResponseEntity.ok(service.getPessoaById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable int id) {
        this.service.deletePessoaById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping()
    public ResponseEntity<Pessoa> save(@Validated @RequestBody Pessoa pessoa) {

        Pessoa novaPessoa = this.service.save(pessoa);
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novaPessoa.getId())
                .toUri();

        return ResponseEntity.created(location).body(novaPessoa);

    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody Pessoa pessoa){
        this.service.update(id, pessoa);
        return ResponseEntity.ok().build();
    }
}
