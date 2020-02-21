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

    public List<DespesasPorFonte> consultarDespesasPorFonte() {

        List<IDespesasPorFonteView> iDespesasPorFonteViews = despesaRepository.consultarDespesasAgrupadoPorFonte();

        DespesasPorFonteFactory despesasPorFonteFactory = new DespesasPorFonteFactory(iDespesasPorFonteViews);

        return despesasPorFonteFactory.toListfontePorMes();
    }


    public List<DespesasPorCategoria> consultarDespesasPorCategoria() {

        List<IDespesasPorCategoria> iDespesasPorCategorias = despesaRepository.consultarDespesasAgrupadoPorCategoria();

        DespesasPorCategoriaFactory despesasPorCategoriaFactory = new DespesasPorCategoriaFactory(iDespesasPorCategorias);

        return despesasPorCategoriaFactory.toListCategoriaPorMes();
    }

    public List<DespesasPorMes> consultarDespesasPorMes() {

        List<IDespesasPorMes> iDespesasPorMes = despesaRepository.consultarDespesasMesAMes();

        DespesasPorMesFactory despesasPorMesFactory = new DespesasPorMesFactory(iDespesasPorMes);

        return despesasPorMesFactory.toListDespesasPorMes();
    }
}
