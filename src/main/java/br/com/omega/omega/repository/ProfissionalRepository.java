package br.com.omega.omega.repository;

import br.com.omega.omega.model.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

    Profissional findProfissionalById(Long id);
}
