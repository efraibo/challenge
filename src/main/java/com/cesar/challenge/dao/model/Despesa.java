package com.cesar.challenge.dao.model;

import com.cesar.challenge.dao.model.converter.DoubleToStringConverter;
import com.cesar.challenge.dao.model.converter.StringToDoubleConverter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode
@Entity
@Builder
public class Despesa {

    @JsonProperty("_id")
    @Id
    private Integer id;

    @JsonProperty("ano_movimentacao")
    private Integer anoMovimentacao;

    @JsonProperty("mes_movimentacao")
    public Integer mesMovimentacao;

    @JsonProperty("orgao_codigo")
    public Integer orgaoCodigo;

    @JsonProperty("orgao_nome")
    public String orgaoNome;

    @JsonProperty("unidade_codigo")
    public Double unidadeCodigo;

    @JsonProperty("unidade_nome")
    public String unidadeNome;

    @JsonProperty("categoria_economica_codigo")
    public Integer categoriaEconomicaCodigo;

    @JsonProperty("categoria_economica_nome")
    public String categoriaEconomicaNome;

    @JsonProperty("grupo_despesa_codigo")
    public Integer grupoDespesaCodigo;

    @JsonProperty("grupo_despesa_nome")
    public String grupoDespesaNome;

    @JsonProperty("modalidade_aplicacao_codigo")
    public Integer modalidadeAplicacaoCodigo;

    @JsonProperty("modalidade_aplicacao_nome")
    public String modalidadeAplicacaoNome;

    @JsonProperty("elemento_codigo")
    public Integer elementoCodigo;

    @JsonProperty("elemento_nome")
    public String elementoNome;

    @JsonProperty("subelemento_codigo")
    public Integer subelementoCodigo;

    @JsonProperty("subelemento_nome")
    public String subelementoNome;

    @JsonProperty("funcao_codigo")
    public Integer funcaoCodigo;

    @JsonProperty("funcao_nome")
    public String funcaoNome;

    @JsonProperty("subfuncao_codigo")
    public Integer subfuncaoCodigo;

    @JsonProperty("subfuncao_nome")
    public String subfuncaoNome;

    @JsonProperty("programa_codigo")
    public Integer programaCodigo;

    @JsonProperty("programa_nome")
    public String programaNome;

    @JsonProperty("acao_codigo")
    public Integer acaoCodigo;

    @JsonProperty("acao_nome")
    public String acaoNome;

    @JsonProperty("fonte_recurso_codigo")
    public Integer fonteRecursoCodigo;

    @JsonProperty("fonte_recurso_nome")
    public String fonteRecursoNome;

    @JsonProperty("empenho_ano")
    public Integer empenhoAno;

    @JsonProperty("empenho_modalidade_nome")
    public String empenhoModalidadeNome;

    @JsonProperty("empenho_modalidade_codigo")
    public Integer empenhoModalidadeCodigo;

    @JsonProperty("empenho_numero")
    public Integer empenhoNumero;

    @JsonProperty("subempenho")
    public Integer subempenho;

    @JsonProperty("indicador_subempenho")
    public String indicadorSubempenho;

    @JsonProperty("credor_codigo")
    public Integer credorCodigo;

    @JsonProperty("credor_nome")
    public String credorNome;

    @JsonProperty("modalidade_licitacao_codigo")
    public Integer modalidadeLicitacaoCodigo;

    @JsonProperty("modalidade_licitacao_nome")
    public String modalidadeLicitacaoNome;

    @JsonProperty("valor_empenhado")
    public String valorEmpenhado;

    @JsonProperty("valor_liquidado")
    public String valorLiquidado;

    @JsonProperty("valor_pago")
    @JsonSerialize(converter = DoubleToStringConverter.class)
    @JsonDeserialize(converter = StringToDoubleConverter.class)
    public Double valorPago;
}
