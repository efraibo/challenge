package com.cesar.challenge.services;

import com.cesar.challenge.config.ConsomeApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@Import(ConsomeApi.class)
@RunWith(SpringRunner.class)
@DataJpaTest
public class DespesasServiceTest {

    @Test
    public void consultarDespesasPorFonte() {
    }

    @Test
    public void consultarDespesasPorCategoria() {
    }

    @Test
    public void consultarDespesasPorMes() {
    }
}