package com.cesar.challenge.dao.view.mes;

import java.util.List;
import java.util.stream.Collectors;

public class DespesasPorMesFactory {

    private List<IDespesasPorMes> iDespesasPorMes;

    public List<DespesasPorMes> toListDespesasPorMes() {
        return iDespesasPorMes
                .stream()
                .map(despesaView -> new DespesasPorMes(despesaView.getMes_movimentacao(), despesaView.getTotal()))
                .collect(Collectors.toList());
    }

    public DespesasPorMesFactory(List<IDespesasPorMes> iDespesasPorMes) {
        this.iDespesasPorMes = iDespesasPorMes;
    }

}
