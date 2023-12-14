package br.com.NinjaVortex;

import br.com.NinjaVortex.models.Ninja;
import br.com.NinjaVortex.service.NinjaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
public class NinjaServiceTest {
    Logger logger = LoggerFactory.getLogger(NinjaService.class);
    @Autowired
    NinjaService ninjaService;
    @Test
    @DisplayName("Testa se a quantidade de itens contidos na lista")
    public void testaGetAll(){
        List<Ninja> ninjas = ninjaService.getAll();
        assertEquals(3, ninjas.size());

    }

    @Test
    @DisplayName("Testa a apresentação de apenas um ninja")
    public void testaGetById(){
        Ninja ninja = ninjaService.getById(0);
        assertEquals("Naruto", ninja.getName());

    }






}
