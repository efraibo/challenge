package com.cesar.challenge.services;

import com.cesar.challenge.dao.repository.DespesaRepository;
import com.cesar.challenge.dao.view.categoria.DespesasPorCategoria;
import com.cesar.challenge.dao.view.categoria.IDespesasPorCategoria;
import com.cesar.challenge.dao.view.fonte.DespesasPorFonte;
import com.cesar.challenge.dao.view.fonte.IDespesasPorFonteView;
import com.cesar.challenge.dao.view.mes.DespesasPorMes;
import com.cesar.challenge.dao.view.mes.IDespesasPorMes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DespesasService {

    @Autowired
    private DespesaRepository despesaRepository;

    public List<DespesasPorFonte> consultarDespesasPorFonte(){

        List<IDespesasPorFonteView> iDespesasPorCategorias = despesaRepository.consultarDespesasAgrupadoPorFonte();

        List<DespesasPorFonte> listaDepesasPorMes = iDespesasPorCategorias
                .stream()
                .map(despesaView -> new DespesasPorFonte(despesaView.getFonte_recurso_nome(), despesaView.getTotal()))
                .collect(Collectors.toList());

        return listaDepesasPorMes;
    }


    public List<DespesasPorCategoria> consultarDespesasPorCategoria(){

        List<IDespesasPorCategoria> iDespesasPorCategorias = despesaRepository.consultarDespesasAgrupadoPorCategoria();

        List<DespesasPorCategoria> listaDepesasPorMes = iDespesasPorCategorias
                .stream()
                .map(despesaView -> new DespesasPorCategoria(despesaView.getCategoria_economica_nome(), despesaView.getTotal()))
                .collect(Collectors.toList());

        return listaDepesasPorMes;
    }

    public List<DespesasPorMes> consultarDespesasPorMes(){

        List<IDespesasPorMes> iDespesasPorMes = despesaRepository.consultarDespesasMesAMes();

        List<DespesasPorMes> listaDepesasPorMes = iDespesasPorMes
                .stream()
                .map(despesaView -> new DespesasPorMes(despesaView.getMes_movimentacao(), despesaView.getTotal()))
                .collect(Collectors.toList());

        return listaDepesasPorMes;
    }


}
