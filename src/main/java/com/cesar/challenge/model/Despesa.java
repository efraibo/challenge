package com.cesar.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Despesa {

    @JsonProperty("ano_movimentacao")
    private Integer anoMovimentacao;

    @JsonProperty("orgao_nome")
    private String nomeOrgao;

    @JsonProperty("valor_pago")
    private String valorPago;

    @JsonProperty("categoria_economica_codigo")
    private Integer codigoCategoria;

    @JsonProperty("categoria_economica_nome")
    private String nomeCategoria;

    @JsonProperty("fonte_recurso_codigo")
    private String codigoRecurso;

    @JsonProperty("fonte_recurso_nome")
    private String fonteRecurso;
}
