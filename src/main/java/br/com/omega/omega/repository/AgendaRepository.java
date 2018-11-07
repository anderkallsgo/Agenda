package br.com.omega.omega.repository;

import br.com.omega.omega.model.Agenda;
import br.com.omega.omega.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    Agenda findAgendaById(Long id);

    List<Agenda> findAgendaByPaciente(Pessoa paciente);
}
