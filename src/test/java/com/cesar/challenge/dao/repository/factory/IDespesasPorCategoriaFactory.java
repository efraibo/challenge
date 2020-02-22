package com.cesar.challenge.dao.repository.factory;

import com.cesar.challenge.dao.view.categoria.IDespesasPorCategoria;

import java.util.Arrays;
import java.util.List;


public class IDespesasPorCategoriaFactory {

    public List<IDespesasPorCategoria> getDespesasPorCategoriaEsperado() {

        IDespesasPorCategoriaImpl iDespesasPorCategoria = IDespesasPorCategoriaImpl.builder().categoriaEconomicaNome("DESPESAS CORRENTES").total(189958.01d).build();

        return Arrays.asList(iDespesasPorCategoria);
    }

}
