package com.cesar.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Despesa {

    @JsonProperty("_id")
    private Integer id;

    @JsonProperty("ano_movimentacao")
    private Integer anoMovimentacao;

}
