package br.com.omega.omega.service;

import br.com.omega.omega.model.Agenda;
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
}
