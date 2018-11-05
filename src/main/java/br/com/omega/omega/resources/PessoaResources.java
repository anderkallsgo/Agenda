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
public class PessoaResources{

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/save")//create
    public ResponseEntity<Pessoa> savePessoa(@RequestBody Pessoa pessoa){
        return ResponseEntity.ok(this.pessoaService.savePessoa(pessoa));
    }
    @GetMapping("/list")//read
    public ResponseEntity<List<?>> getPessoas(){
        return new ResponseEntity<>(this.pessoaService.listPessoa(), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{idPessoa}")//delete
    public ResponseEntity<?> deletePessoa(@PathVariable("idPessoa") Long id){
        Pessoa pessoa = this.pessoaService.findPessoaById(id);
        if (pessoa != null){
            this.pessoaService.deletePessoa(pessoa);
            return ResponseEntity.ok("Deletado Com Sucesso");
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{idPessoa}")//update
    public ResponseEntity<?> updatePessoa(@RequestBody Pessoa pessoaAtual, @PathVariable("idPessoa") Long id){
        Pessoa pessoa = this.pessoaService.findPessoaById(id);
        if (pessoa != null){
            pessoa.setNome(pessoaAtual.getNome());
            pessoa.setCpf(pessoaAtual.getCpf());
            this.pessoaService.updatePessoa(pessoa);
            return ResponseEntity.ok("Atualizado com Sucesso");
        }
        return ResponseEntity.noContent().build();
    }
}
