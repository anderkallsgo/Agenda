package br.com.omega.omega.resources;

import br.com.omega.omega.model.Agenda;
import br.com.omega.omega.model.Pessoa;
import br.com.omega.omega.service.AgendaService;
import br.com.omega.omega.service.OmegaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agenda")

public class AgendaResources {

    @Autowired
    private AgendaService agendaService;
    @Autowired
    private OmegaService omegaService;

    @GetMapping("/testeAgenda")
    public ResponseEntity<?> testeAgenda(){
        Boolean deuCerto = true;
        if (deuCerto == true){
            return ResponseEntity.ok("Deu Certo");
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveAgenda(@RequestBody Agenda agenda){
        if (agenda.getPaciente() != null){
            Pessoa pessoa = this.omegaService.findPessoaById(agenda.getPaciente().getId());
            if(pessoa != null){
                agenda.setPaciente(pessoa);
                return ResponseEntity.ok(this.omegaService.saveAgendamento(agenda));
            }else{
                return ResponseEntity.ok("Pessoa não encontrada");
            }
        }
        return ResponseEntity.ok("Paciente não encontrado");
    }

}
