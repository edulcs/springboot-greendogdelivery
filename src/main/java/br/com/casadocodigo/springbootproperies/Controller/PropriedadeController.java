package br.com.casadocodigo.springbootproperies.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casadocodigo.springbootproperies.repository.PropriedadeRepository;
import br.com.casadocodigo.springbootproperies.repository.model.Propriedade;

@RestController
@RequestMapping("api/")
public class PropriedadeController {

    @Autowired
    private PropriedadeRepository respository;

    @GetMapping(value="/find/{filter}")
    List<Propriedade> findByFiltro(@PathVariable("filter") String filter){
        return respository.findByFiltro(filter);
    }
}
