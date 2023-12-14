package br.com.NinjaVortex.controllers;

import br.com.NinjaVortex.models.Ninja;
import br.com.NinjaVortex.service.NinjaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {
    Logger logger = LoggerFactory.getLogger(NinjaController.class);
    @Autowired
    NinjaService ninjaService;
    @GetMapping
    public List<Ninja> getAll(){
        logger.info("GET ALL NINJAS");
        return ninjaService.getAll();
    }

    @GetMapping("/{id}")
    public Ninja getById(@PathVariable int id){
        logger.info("GET NINJA: " + id);
        return ninjaService.getById(id);

    }

    @PostMapping
    public void salvar(@RequestBody Ninja ninja){
        logger.info("SALVAR NINJA " + ninja);
        ninjaService.salvar(ninja);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id){
        logger.info("Deletar um NINJA" + id);
        ninjaService.deletar(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable int id,@RequestBody Ninja ninja){
        logger.info("ATUALIZAR NINJA: " + ninja);
        ninjaService.atualizar(id,ninja);
    }


}
