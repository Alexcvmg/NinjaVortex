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
        Jutso jutso4 = new Jutso("Raio Ninja", "Ataque elétrico", "Ofensivo", "Médio");
        Jutso jutso5 = new Jutso("Terra Ninja", "Barreira de terra", "Defensivo", "Alto");
        Jutso jutso6 = new Jutso("Gelo Ninja", "Ataque congelante", "Ofensivo", "Baixo");
        Jutso jutso7 = new Jutso("Sombra Ninja", "Teleporte sombrio", "Evasivo", "Alto");
        Jutso jutso8 = new Jutso("Ilusão Ninja", "Ilusão sensorial", "Enganador", "Baixo");
        Jutso jutso9 = new Jutso("Magnetismo Ninja", "Controle magnético", "Ofensivo", "Médio");
        Jutso jutso10 = new Jutso("Explosão Ninja", "Explosão de chakra", "Ofensivo", "Alto");

        Ninja ninja1 = new Ninja(0, "Naruto", "Hokage", Arrays.asList(jutso1, jutso2), "Vento");
        Ninja ninja2 = new Ninja(1, "Sasuke", "Chunin", Arrays.asList(jutso3, jutso8), "Fogo");
        Ninja ninja3 = new Ninja(2, "Kakashi", "Jonin", Arrays.asList(jutso2, jutso3), "Água");
        Ninja ninja4 = new Ninja(3, "Hinata", "Jonin", Arrays.asList(jutso4, jutso5), "Raio");
        Ninja ninja5 = new Ninja(4, "Shikamaru", "Chunin", Arrays.asList(jutso5, jutso6), "Terra");
        Ninja ninja6 = new Ninja(5, "Temari", "Jonin", Arrays.asList(jutso4, jutso6), "Vento");
        Ninja ninja7 = new Ninja(6, "Ino", "Chunin", Arrays.asList(jutso7, jutso8), "Ilusão");
        Ninja ninja8 = new Ninja(7, "Kiba", "Jonin", Arrays.asList(jutso9, jutso10), "Explosão");
        Ninja ninja9 = new Ninja(8, "Rock Lee", "Chunin", Arrays.asList(jutso10, jutso7), "Taijutsu");
        Ninja ninja10 = new Ninja(9, "Neji", "Jonin", Arrays.asList(jutso8, jutso9), "Byakugan");

        ArrayList<Ninja> ninjas = new ArrayList<>();
        ninjas.add(ninja1);
        ninjas.add(ninja2);
        ninjas.add(ninja3);
        ninjas.add(ninja4);
        ninjas.add(ninja5);
        ninjas.add(ninja6);
        ninjas.add(ninja7);
        ninjas.add(ninja8);
        ninjas.add(ninja9);
        ninjas.add(ninja10);
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
