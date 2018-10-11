package br.com.omega.omega.resources;

import br.com.omega.omega.model.Profissional;
import br.com.omega.omega.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profissional")

public class ProfissionalResources {

    @Autowired
    private ProfissionalService profissionalService;


}
