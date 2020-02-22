package com.cesar.challenge.dao.view.mes;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DespesasPorMesFactory {

    private List<IDespesasPorMes> iDespesasPorMes;


    public List<DespesasPorMes> toListDespesasPorMes(List<IDespesasPorMes> iDespesasPorMes) {
        return iDespesasPorMes
                .stream()
                .map(despesaView -> new DespesasPorMes(despesaView.getMes_movimentacao(), despesaView.getTotal()))
                .collect(Collectors.toList());
    }



}