package com.cesar.challenge.util;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class UriUtils {
    public UriComponents getDespesaUri() {
        return UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("dados.recife.pe.gov.br")
                .path("api/3/action/datastore_search")
                .queryParam("resource_id", "dc9744c1-ab3d-4597-b8ce-a01c9ee2fdda")
                .build();

    }
}
