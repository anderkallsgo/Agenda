package br.com.omega.omega.resources;

import br.com.omega.omega.model.Profissional;
import br.com.omega.omega.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissional")

public class ProfissionalResources {

    @Autowired
    private ProfissionalService profissionalService;

    @GetMapping("/testeProfissinal")
    public ResponseEntity<?> testeProfissional(){
        Boolean deuCerto = true;
        if (deuCerto == true){
            return ResponseEntity.ok("Deu Certo");
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/save")
    public ResponseEntity<Profissional> saveProfissional(@RequestBody Profissional profissional){
        return ResponseEntity.ok(this.profissionalService.saveProfissional(profissional));
    }

    @DeleteMapping("/delete/{idProfissional}")
    public ResponseEntity<?> deleteProfissional(@PathVariable("idProfissional") Long id){
        Profissional profissional = this.profissionalService.findProfissionalById(id);
        if (profissional != null){
            this.profissionalService.deleteProfissional(profissional);
            return ResponseEntity.ok("Deletado com Sucesso");
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listProfissional")
    public ResponseEntity<List<?>> getListProfissional(){
        return new ResponseEntity<>(this.profissionalService.listProfissinal(),HttpStatus.OK);
    }
}
