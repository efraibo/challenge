package com.cesar.challenge.dao.view.categoria;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DespesasPorCategoriaFactory {

    private List<IDespesasPorCategoria> iDespesasPorCategorias;

    public List<DespesasPorCategoria> toListCategoriaPorMes(List<IDespesasPorCategoria> iDespesasPorCategorias) {
        return iDespesasPorCategorias
                .stream()
                .map(despesaView -> new DespesasPorCategoria(despesaView.getCategoria_economica_nome(), despesaView.getTotal()))
                .collect(Collectors.toList());
    }

}
