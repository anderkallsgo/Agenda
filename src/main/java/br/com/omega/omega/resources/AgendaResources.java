package br.com.omega.omega.resources;

import br.com.omega.omega.model.Agenda;
import br.com.omega.omega.model.Pessoa;
import br.com.omega.omega.model.Profissional;
import br.com.omega.omega.service.AgendaService;
import br.com.omega.omega.service.PessoaService;
import br.com.omega.omega.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agenda")

public class AgendaResources {

    @Autowired
    private AgendaService agendaService;
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private ProfissionalService profissionalService;

    @GetMapping("/testeAgenda")
    public ResponseEntity<?> testeAgenda(){
        Boolean deuCerto = true;
        if (deuCerto == true){
            return ResponseEntity.ok("Deu Certo");
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/save")//create
    public ResponseEntity<?> saveAgenda(@RequestBody Agenda agenda){
        if (agenda.getPaciente() != null && agenda.getPsicologo() != null){
            Pessoa pessoa = this.pessoaService.findPessoaById(agenda.getPaciente().getId());
            Profissional profissional = this.profissionalService.findProfissionalById(agenda.getPsicologo().getId());
            if(pessoa != null && profissional != null){
                agenda.setPaciente(pessoa);
                agenda.setPsicologo(profissional);
                return ResponseEntity.ok(this.pessoaService.saveAgendamento(agenda));
            }else{
                return ResponseEntity.ok("Pessoa não encontrada");
            }
        }
        return ResponseEntity.ok("Paciente não encontrado");
    }

    @GetMapping("/list-agendamentos")//read
    public ResponseEntity<List<?>> getAgendammentos(){
        return new ResponseEntity<>(this.agendaService.listAgendametos(), HttpStatus.OK);
    }

    @DeleteMapping("/delete-agendamentos/{idAgendamento}")//delete
    public ResponseEntity<?> deleteAgendamentos(@PathVariable("idAgendamento") Long id){
        Agenda agenda = this.agendaService.findAgendaById(id);
        if (agenda != null){
            this.agendaService.removerAgendamento(agenda);
            return ResponseEntity.ok("Deletado com Sucesso");
        }
        return ResponseEntity.ok("Agendamento não Encontrado");
    }

    @PutMapping("/update/{idAgendamento}")//update
    public ResponseEntity<?> updateAgendamento(@PathVariable("idAgendamento") Long id, @RequestBody Agenda agenda){
        Agenda agendaBanco = this.agendaService.findAgendaById(id);
        if (agendaBanco != null){
            if (agenda.getData() != null){
                agendaBanco.setData(agenda.getData());
            }
            if (agenda.getObservacao() != null && !agenda.getObservacao().equals("")){
                agendaBanco.setObservacao(agenda.getObservacao());
            }
            return ResponseEntity.ok(this.agendaService.updateAgendamentos(agendaBanco));
        }
        return ResponseEntity.ok("Agendamento não Atualizado");
    }

    @GetMapping("/listAgendamentosPaciente/{idPaciente}")
    public ResponseEntity<List<?>> getAgendamentosPaciente(@PathVariable("idPaciente") Long id){
        Pessoa paciente = this.pessoaService.findPessoaById(id);
        if (paciente != null){
            return new ResponseEntity<>(this.agendaService.listAgendametosByPaciente(paciente), HttpStatus.OK);
        }
        return ResponseEntity.noContent().build();
    }
}
