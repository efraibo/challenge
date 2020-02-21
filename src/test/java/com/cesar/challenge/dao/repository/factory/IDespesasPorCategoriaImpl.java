package com.cesar.challenge.dao.repository.factory;

import com.cesar.challenge.dao.view.categoria.IDespesasPorCategoria;
import lombok.Builder;

@Builder
public class IDespesasPorCategoriaImpl implements IDespesasPorCategoria {

    private String categoriaEconomicaNome;
    private Double total;

    @Override
    public String getCategoria_economica_nome() {
        return categoriaEconomicaNome;
    }

    @Override
    public Double getTotal() {
        return total;
    }
}
