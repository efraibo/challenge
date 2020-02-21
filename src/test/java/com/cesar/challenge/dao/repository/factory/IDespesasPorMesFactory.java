package com.cesar.challenge.dao.repository.factory;

import com.cesar.challenge.dao.view.mes.IDespesasPorMes;

import java.util.Arrays;
import java.util.List;


public class IDespesasPorMesFactory {

    public List<IDespesasPorMes> getDespesasPorMesEsperado() {

        IDespesasPorMes despesasJaneiro = IDespesasPorMesImpl.builder().mesMovimentacao(1).total(189958.01).build();

        return Arrays.asList(despesasJaneiro);
    }

}
