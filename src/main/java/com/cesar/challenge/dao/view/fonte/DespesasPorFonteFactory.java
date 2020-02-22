package com.cesar.challenge.dao.view.fonte;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DespesasPorFonteFactory {

    private List<IDespesasPorFonteView> iDespesasPorFonteViews;

    public List<DespesasPorFonte> toListfontePorMes(List<IDespesasPorFonteView> iDespesasPorFonteViews) {
        return iDespesasPorFonteViews
                .stream()
                .map(despesaView -> new DespesasPorFonte(despesaView.getFonte_recurso_nome(), despesaView.getTotal()))
                .collect(Collectors.toList());
    }
}
