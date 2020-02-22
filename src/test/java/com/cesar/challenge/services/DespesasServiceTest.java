package com.cesar.challenge.services;

import com.cesar.challenge.dao.repository.DespesaRepository;
import com.cesar.challenge.dao.repository.factory.IDespesasPorCategoriaFactory;
import com.cesar.challenge.dao.repository.factory.IDespesasPorFonteFactory;
import com.cesar.challenge.dao.repository.factory.IDespesasPorMesFactory;
import com.cesar.challenge.dao.view.categoria.DespesasPorCategoriaFactory;
import com.cesar.challenge.dao.view.categoria.IDespesasPorCategoria;
import com.cesar.challenge.dao.view.fonte.DespesasPorFonteFactory;
import com.cesar.challenge.dao.view.fonte.IDespesasPorFonteView;
import com.cesar.challenge.dao.view.mes.DespesasPorMesFactory;
import com.cesar.challenge.dao.view.mes.IDespesasPorMes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class DespesasServiceTest {

    @Mock
    private DespesaRepository despesaRepository;

    @Mock
    private DespesasPorMesFactory despesasPorMesFactory;

    @Mock
    private DespesasPorFonteFactory despesasPorFonteFactory;

    @Mock
    private DespesasPorCategoriaFactory despesasPorCategoriaFactory;

    @InjectMocks
    private DespesasService despesasService;

    @Test
    public void consultarDespesasPorMes() {

        IDespesasPorMesFactory iDespesasPorMesFactory = new IDespesasPorMesFactory();
        List<IDespesasPorMes> iDespesasPorMes = iDespesasPorMesFactory.getDespesasPorMesEsperado();

        when(despesaRepository.consultarDespesasMesAMes()).thenReturn(iDespesasPorMes);

        despesasService.consultarDespesasPorMes();

        verify(despesasPorMesFactory, times(1)).toListDespesasPorMes(iDespesasPorMes);

    }

    @Test
    public void consultarDespesasPorFonte() {
        IDespesasPorFonteFactory iDespesasPorFonteFactory = new IDespesasPorFonteFactory();
        List<IDespesasPorFonteView> iDespesasPorFonteViews = iDespesasPorFonteFactory.getDespesasPorFonteEsperado();

        when(despesaRepository.consultarDespesasAgrupadoPorFonte()).thenReturn(iDespesasPorFonteViews);

        despesasService.consultarDespesasPorFonte();

        verify(despesasPorFonteFactory, times(1)).toListfontePorMes(iDespesasPorFonteViews);
    }

    @Test
    public void consultarDespesasPorCategoria() {
        IDespesasPorCategoriaFactory iDespesasPorCategoriaFactory = new IDespesasPorCategoriaFactory();
        List<IDespesasPorCategoria> iDespesasPorCategorias = iDespesasPorCategoriaFactory.getDespesasPorCategoriaEsperado();

        when(despesaRepository.consultarDespesasAgrupadoPorCategoria()).thenReturn(iDespesasPorCategorias);

        despesasService.consultarDespesasPorCategoria();

        verify(despesasPorCategoriaFactory, times(1)).toListCategoriaPorMes(iDespesasPorCategorias);
    }
}