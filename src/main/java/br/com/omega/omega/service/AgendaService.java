package br.com.omega.omega.service;

import br.com.omega.omega.model.Agenda;
import br.com.omega.omega.model.Pessoa;
import br.com.omega.omega.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;


    public List<Agenda> listAgendametos() {
    return agendaRepository.findAll();
    }

    public Agenda findAgendaById(Long id) {
        return agendaRepository.findAgendaById(id);
    }

    public void removerAgendamento(Agenda agenda) {
        agendaRepository.delete(agenda);
    }

    public Agenda updateAgendamentos(Agenda agendaBanco) {
        return this.agendaRepository.save(agendaBanco);
    }

    public List<Agenda> listAgendametosByPaciente(Pessoa paciente) {
        return agendaRepository.findAgendaByPaciente(paciente);
    }
}
