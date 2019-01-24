package br.com.omega.omega.resources;

import br.com.omega.omega.model.Pessoa;
import br.com.omega.omega.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
@CrossOrigin
public class PessoaResources {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/teste")
    public ResponseEntity<String> getOmegas(){
        boolean deuCerto = true;
        if (deuCerto){
            return ResponseEntity.ok("Hello World");
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/save")//create
    public ResponseEntity<Pessoa> savePessoa(@RequestBody Pessoa pessoa){
        return ResponseEntity.ok(this.pessoaService.savePessoa(pessoa));
    }
    @GetMapping("/list")//read
    public ResponseEntity<List<?>> getPessoaOmega(){
        return new ResponseEntity<>(this.pessoaService.listPessoa(), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{idPessoa}")//delete
    public ResponseEntity<?> deletePessoaOmega(@PathVariable("idPessoa") Long id){
        Pessoa pessoa = this.pessoaService.findPessoaById(id);
        if (pessoa != null){
            this.pessoaService.deletePessoaOmega(pessoa);
            return ResponseEntity.ok("Deletado Com Sucesso");
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{idPessoa}")//update
    public ResponseEntity<?> updatePessoaOmega(@RequestBody Pessoa pessoaAtual, @PathVariable("idPessoa") Long id){
        Pessoa pessoa = this.pessoaService.findPessoaById(id);
        if (pessoa != null){
            pessoa.setNome(pessoaAtual.getNome());
            pessoa.setCpf(pessoaAtual.getCpf());
            this.pessoaService.updatePessoaOmega(pessoa);
            return ResponseEntity.ok("Atualizado com Sucesso");
        }
        return ResponseEntity.noContent().build();
    }
}
