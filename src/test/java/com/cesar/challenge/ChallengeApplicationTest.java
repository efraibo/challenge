package com.cesar.challenge;

import com.cesar.challenge.dao.model.Despesa;
import com.cesar.challenge.dao.repository.DespesaRepository;
import com.cesar.challenge.model.DespesaResponse;
import com.cesar.challenge.model.ListaDespesas;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChallengeApplicationTest {

    @Autowired
    private DespesaRepository despesaRepository;

    @Test
    public void consumerAPI() {
        //"https://api.trello.com/1/boards/5612e4f91b25c15e873722b8?fields=all";
        RestTemplate template = new RestTemplate();
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.trello.com")
                .path("1/boards/5612e4f91b25c15e873722b8")
                .queryParam("fields", "all")
                .build();


        ResponseEntity<Trello> entity = template.getForEntity(uri.toUriString(), Trello.class);

        System.out.println(entity.getBody().getName());

    }

    @Test
    public void consumerApiPrefeituraRecife() throws JSONException {
        //http://dados.recife.pe.gov.br/api/3/action/datastore_search?resource_id=718e6705-a7e1-4395-a7c5-13c141c182f7&limit=5

        RestTemplate template = new RestTemplate();
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("dados.recife.pe.gov.br")
                .path("api/3/action/datastore_search")
                .build();

        int tamanhoRetorno = 100;
        int offset = 0;

        do {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("q", "");
            jsonObject.put("resource_id", "dc9744c1-ab3d-4597-b8ce-a01c9ee2fdda");
            jsonObject.put("limit", "100");
            jsonObject.put("offset", String.valueOf(offset));

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<String>(jsonObject.toString(), headers);

            ListaDespesas listaDespesas = template.postForObject(uri.toUriString(), request, DespesaResponse.class).getListaDespesas();

            List<Despesa> despesas = listaDespesas.getDespesas();

            despesaRepository.saveAll(despesas);

            tamanhoRetorno = despesas.size();

            offset += 100;

        }while (tamanhoRetorno < 100);

        System.out.println("");

    }

}