package com.cesar.challenge.dao.repository.factory;

import com.cesar.challenge.dao.view.mes.IDespesasPorMes;
import lombok.Builder;

@Builder
public class IDespesasPorMesImpl implements IDespesasPorMes {

    private Integer mesMovimentacao;
    private Double total;

    @Override
    public Integer getMes_movimentacao() {
        return mesMovimentacao;
    }

    @Override
    public Double getTotal() {
        return total;
    }
}
