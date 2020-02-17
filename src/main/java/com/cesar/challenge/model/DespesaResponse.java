package com.cesar.challenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DespesaResponse {

    @JsonProperty("result")
    private ListaDespesas listaDespesas;
}
