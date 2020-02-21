package com.cesar.challenge.dao.view.categoria;

import java.util.List;
import java.util.stream.Collectors;

public class DespesasPorCategoriaFactory {

    private List<IDespesasPorCategoria> iDespesasPorCategorias;

    public List<DespesasPorCategoria> toListCategoriaPorMes() {
        return iDespesasPorCategorias
                .stream()
                .map(despesaView -> new DespesasPorCategoria(despesaView.getCategoria_economica_nome(), despesaView.getTotal()))
                .collect(Collectors.toList());
    }

    public DespesasPorCategoriaFactory(List<IDespesasPorCategoria> iDespesasPorCategorias) {
        this.iDespesasPorCategorias = iDespesasPorCategorias;
    }

}
