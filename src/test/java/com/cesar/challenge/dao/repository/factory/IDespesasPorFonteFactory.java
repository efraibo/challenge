package com.cesar.challenge.dao.repository.factory;

import com.cesar.challenge.dao.view.fonte.IDespesasPorFonteView;

import java.util.Arrays;
import java.util.List;


public class IDespesasPorFonteFactory {

    public List<IDespesasPorFonteView> getDespesasPorFonteEsperado() {

        IDespesasPorFonteImpl iDespesasPorFonte = IDespesasPorFonteImpl.builder().fonteRecursoNome("RECURSOS ORDINÁRIOS - NÃO VINCULADOS").total(189958.01d).build();

        return Arrays.asList(iDespesasPorFonte);
    }

}
