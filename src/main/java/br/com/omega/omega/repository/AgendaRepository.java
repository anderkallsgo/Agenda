package br.com.omega.omega.repository;

import br.com.omega.omega.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    Agenda findAgendaById(Long id);
}
