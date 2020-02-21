package com.cesar.challenge.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DespesaControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private static final ObjectMapper om = new ObjectMapper();

    @Test
    public void getDespesasTotaisPorMes() {
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/despesas/mes", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        String respostaRecebida = response.getBody();
        String respostaEsperada = "[{\"mes_movimento\":1,\"total\":189958.01},{\"mes_movimento\":2,\"total\":909544.6799999999},{\"mes_movimento\":3,\"total\":134110.19999999998},{\"mes_movimento\":4,\"total\":100603.17000000001},{\"mes_movimento\":5,\"total\":177984.94999999998},{\"mes_movimento\":6,\"total\":112281.23999999999},{\"mes_movimento\":7,\"total\":155754.14},{\"mes_movimento\":8,\"total\":1112424.1},{\"mes_movimento\":9,\"total\":165121.13},{\"mes_movimento\":10,\"total\":231361.59999999998},{\"mes_movimento\":11,\"total\":129987.51},{\"mes_movimento\":12,\"total\":767828.1599999999}]";
        assertEquals(respostaEsperada, respostaRecebida);



    }

    @Test
    public void getDespesasTotaisPorCategoria() {
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/despesas/categoria", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void getDespesasTotaisPorFonte() {
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/despesas/fonte", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}