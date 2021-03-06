package com.cesar.challenge.model;

import com.cesar.challenge.dao.model.Despesa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListaDespesas {
    @JsonProperty("records")
    private List<Despesa> despesas;
}
