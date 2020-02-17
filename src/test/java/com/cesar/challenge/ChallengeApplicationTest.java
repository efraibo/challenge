package com.cesar.challenge;

import com.cesar.challenge.model.DespesaResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChallengeApplicationTest {

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
    public void consumerApiPrefeituraRecife() {
        //http://dados.recife.pe.gov.br/api/3/action/datastore_search?resource_id=718e6705-a7e1-4395-a7c5-13c141c182f7&limit=5

        RestTemplate template = new RestTemplate();
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("dados.recife.pe.gov.br")
                .path("api/3/action/datastore_search")
                .queryParam("resource_id", "718e6705-a7e1-4395-a7c5-13c141c182f7")
                .queryParam("limit", 5)
                .build();


//        ResponseEntity<Object[]> responseEntity = template.getForEntity(uri.toUriString(), Object[].class);
//        Object[] objects = responseEntity.getBody();

        template.getForObject(uri.toUriString(), DespesaResponse.class).getListaDespesas();


        //System.out.println(forEntity.getBody());

    }

}