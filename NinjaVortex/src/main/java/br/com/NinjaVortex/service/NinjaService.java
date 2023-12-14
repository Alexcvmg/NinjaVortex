package br.com.NinjaVortex.service;

import br.com.NinjaVortex.models.Jutso;
import br.com.NinjaVortex.models.Ninja;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class NinjaService {
    Logger logger = LoggerFactory.getLogger(NinjaService.class);
    List<Ninja> ninjas = listaInicial();

    private List<Ninja> listaInicial(){
        Jutso jutso1 = new Jutso("Fogo Ninja", "Ataque de fogo", "Ofensivo", "Alto");
        Jutso jutso2 = new Jutso("Água Ninja", "Escudo de água", "Defensivo", "Médio");
        Jutso jutso3 = new Jutso("Vento Ninja", "Ataque de vento cortante", "Ofensivo", "Baixo");

        Ninja ninja1 = new Ninja(0, "Naruto", "Hokage", Arrays.asList(jutso1, jutso2), "Vento");
        Ninja ninja2 = new Ninja(1, "Sasuke", "Chunin", Arrays.asList(jutso3), "Fogo");
        Ninja ninja3 = new Ninja(2, "Kakashi", "Jonin", Arrays.asList(jutso2, jutso3), "Água");

        ArrayList<Ninja> ninjas = new ArrayList<>();
        ninjas.add(ninja1);
        ninjas.add(ninja2);
        ninjas.add(ninja3);
        return ninjas;
    }
    public List<Ninja> getAll(){
        return ninjas;
    }

    public Ninja getById(int id){
        return ninjas.get(id);
    }

    public void salvar(Ninja ninja){
        ninjas.add(ninja);
    }

    public Ninja deletar(int id){
        return ninjas.remove(id);
    }

    public void atualizar(int id, Ninja ninja) {
        if (id >= 0 && id < ninjas.size()) {
            Ninja ninjaExistente = ninjas.get(id);
            ninjaExistente.setId(ninja.getId());
            ninjaExistente.setName(ninja.getName());
            ninjaExistente.setRank(ninja.getRank());
            ninjaExistente.setJutsos(ninja.getJutsos());
            ninjaExistente.setElemento(ninja.getElemento());

            logger.info("Ninja atualizado: " + ninjaExistente);
        } else {
            logger.error("ID inválido para atualização: " + id);
        }
    }

}
