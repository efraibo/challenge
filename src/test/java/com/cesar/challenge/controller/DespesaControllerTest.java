package com.cesar.challenge.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@TestPropertySource(locations = "classpath:challengeMessageResponseTest.properties")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DespesaControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Value("${resposta.despesas.totais.mes}")
    private String respostaDespesaTotalPorMes;

    @Value("${resposta.despesas.totais.categoria}")
    private String respostaDespesasTotaisPorCategoria;

    @Value("${reposta.despesas.totais.fonte}")
    private String respostaDespesasTotaisPorFonte;

    private static final ObjectMapper om = new ObjectMapper();

    @Test
    public void getDespesasTotaisPorMes() {
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/despesas/mes", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        String respostaRecebida = response.getBody();
        String respostaEsperada = respostaDespesaTotalPorMes;
        assertEquals(respostaEsperada, respostaRecebida);
    }

    @Test
    public void getDespesasTotaisPorCategoria() {
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/despesas/categoria", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        String respostaRecebida = response.getBody();
        String respostaEsperada = respostaDespesasTotaisPorCategoria;
        assertEquals(respostaEsperada, respostaRecebida);
    }

    @Test
    public void getDespesasTotaisPorFonte() {
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/despesas/fonte", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        String repostaRespondida = response.getBody();
        String repostaEsperada = respostaDespesasTotaisPorFonte;
        assertEquals(repostaRespondida, repostaEsperada);
    }

}