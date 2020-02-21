package com.cesar.challenge.services;

import com.cesar.challenge.dao.repository.DespesaRepository;
import com.cesar.challenge.dao.repository.factory.IDespesasPorMesFactory;
import com.cesar.challenge.dao.view.mes.DespesasPorMesFactory;
import com.cesar.challenge.dao.view.mes.IDespesasPorMes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class DespesasServiceTest {

    @Mock
    private DespesaRepository despesaRepository;

    @InjectMocks
    private DespesasService despesasService;

    @Test
    public void consultarDespesasPorMes() {

        IDespesasPorMesFactory iDespesasPorMesFactory = new IDespesasPorMesFactory();
        List<IDespesasPorMes> iDespesasPorMes = iDespesasPorMesFactory.getDespesasPorMesEsperado();
        DespesasPorMesFactory despesasPorMesFactory = new DespesasPorMesFactory(iDespesasPorMes);

        //procurar como mocar um construtor
        Mockito.mock(DespesasPorMesFactory.class);
        when(despesaRepository.consultarDespesasMesAMes()).thenReturn(iDespesasPorMes);
        when(new DespesasPorMesFactory(iDespesasPorMes)).thenReturn(despesasPorMesFactory);

        verify(despesasPorMesFactory.toListDespesasPorMes(), times(1));

    }

    @Test
    public void consultarDespesasPorFonte() {
    }

    @Test
    public void consultarDespesasPorCategoria() {
    }
}