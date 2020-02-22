package com.cesar.challenge.services;

import com.cesar.challenge.dao.repository.DespesaRepository;
import com.cesar.challenge.dao.view.categoria.DespesasPorCategoria;
import com.cesar.challenge.dao.view.categoria.DespesasPorCategoriaFactory;
import com.cesar.challenge.dao.view.categoria.IDespesasPorCategoria;
import com.cesar.challenge.dao.view.fonte.DespesasPorFonte;
import com.cesar.challenge.dao.view.fonte.DespesasPorFonteFactory;
import com.cesar.challenge.dao.view.fonte.IDespesasPorFonteView;
import com.cesar.challenge.dao.view.mes.DespesasPorMes;
import com.cesar.challenge.dao.view.mes.DespesasPorMesFactory;
import com.cesar.challenge.dao.view.mes.IDespesasPorMes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DespesasService {

    @Autowired
    private DespesaRepository despesaRepository;

    @Autowired
    private DespesasPorMesFactory despesasPorMesFactory;

    @Autowired
    private DespesasPorFonteFactory despesasPorFonteFactory;

    @Autowired
    private DespesasPorCategoriaFactory despesasPorCategoriaFactory;

    public List<DespesasPorFonte> consultarDespesasPorFonte() {

        List<IDespesasPorFonteView> iDespesasPorFonteViews = despesaRepository.consultarDespesasAgrupadoPorFonte();

        return despesasPorFonteFactory.toListfontePorMes(iDespesasPorFonteViews);
    }


    public List<DespesasPorCategoria> consultarDespesasPorCategoria() {

        List<IDespesasPorCategoria> iDespesasPorCategorias = despesaRepository.consultarDespesasAgrupadoPorCategoria();

        return despesasPorCategoriaFactory.toListCategoriaPorMes(iDespesasPorCategorias);
    }

    public List<DespesasPorMes> consultarDespesasPorMes() {

        List<IDespesasPorMes> iDespesasPorMes = despesaRepository.consultarDespesasMesAMes();

        return despesasPorMesFactory.toListDespesasPorMes(iDespesasPorMes);
    }
}