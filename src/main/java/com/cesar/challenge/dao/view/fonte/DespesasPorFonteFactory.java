package com.cesar.challenge.dao.view.fonte;

import java.util.List;
import java.util.stream.Collectors;

public class DespesasPorFonteFactory {

    private List<IDespesasPorFonteView> iDespesasPorFonteViews;

    public List<DespesasPorFonte> toListfontePorMes() {
        return iDespesasPorFonteViews
                .stream()
                .map(despesaView -> new DespesasPorFonte(despesaView.getFonte_recurso_nome(), despesaView.getTotal()))
                .collect(Collectors.toList());
    }

    public DespesasPorFonteFactory(List<IDespesasPorFonteView> iDespesasPorFonteViews) {
        this.iDespesasPorFonteViews = iDespesasPorFonteViews;
    }

}
