package com.cesar.challenge.dao.repository.factory;

import com.cesar.challenge.dao.view.fonte.IDespesasPorFonteView;
import lombok.Builder;

@Builder
public class IDespesasPorFonteImpl implements IDespesasPorFonteView {

    private String fonteRecursoNome;
    private Double total;

    @Override
    public String getFonte_recurso_nome() {
        return fonteRecursoNome;
    }

    @Override
    public Double getTotal() {
        return total;
    }
}
