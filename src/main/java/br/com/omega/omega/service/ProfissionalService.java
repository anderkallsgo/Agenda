package br.com.omega.omega.service;

import br.com.omega.omega.model.Profissional;
import br.com.omega.omega.repository.ProfissionalRepository;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    public Profissional saveProfissional(Profissional profissional) {
        return profissionalRepository.save(profissional);
    }

    public Profissional findProfissionalById(Long id) {
        return profissionalRepository.findProfissionalById(id);
    }

    public void deleteProfissional(Profissional profissional) {
        this.profissionalRepository.delete(profissional);
    }

    public List<Profissional> listProfissinal() {
        return profissionalRepository.findAll();
    }
}
