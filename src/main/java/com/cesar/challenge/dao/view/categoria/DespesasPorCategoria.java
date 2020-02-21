package com.cesar.challenge.dao.view.categoria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class DespesasPorCategoria {

    private String categoria_economica_nome;
    private Double total;
}
