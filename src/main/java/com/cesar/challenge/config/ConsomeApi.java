package com.cesar.challenge.config;

import com.cesar.challenge.dao.model.Despesa;
import com.cesar.challenge.dao.repository.DespesaRepository;
import com.cesar.challenge.model.DespesaResponse;
import com.cesar.challenge.model.ListaDespesas;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Configuration
public class ConsomeApi {

    @Autowired
    private DespesaRepository despesaRepository;

    @Bean
    public void inserirDadosIniciais() {
        RestTemplate template = new RestTemplate();
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("dados.recife.pe.gov.br")
                .path("api/3/action/datastore_search")
                .build();

        int tamanhoRetorno = 100;
        int offset = 0;
        try {
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

            } while (tamanhoRetorno < 100);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println("");
    }

}
