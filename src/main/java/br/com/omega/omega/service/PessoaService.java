package br.com.omega.omega.service;

import br.com.omega.omega.model.Agenda;
import br.com.omega.omega.model.Pessoa;
import br.com.omega.omega.repository.AgendaRepository;
import br.com.omega.omega.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private AgendaRepository agendaRepository;

    public Pessoa savePessoa(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listPessoa() {
        return pessoaRepository.findAll();
    }

    public Pessoa findPessoaById(Long id) {
        return pessoaRepository.findPessoaById(id);
    }

    public void deletePessoaOmega(Pessoa pessoa) {
        this.pessoaRepository.delete(pessoa);
    }

    public Pessoa updatePessoaOmega(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Agenda saveAgendamento(Agenda agenda) {
        return this.agendaRepository.save(agenda);
    }
}
