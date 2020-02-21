package com.cesar.challenge.dao.repository;

import com.cesar.challenge.config.CarregarDadosDespesas;
import com.cesar.challenge.dao.repository.factory.IDespesasPorCategoriaFactory;
import com.cesar.challenge.dao.repository.factory.IDespesasPorFonteFactory;
import com.cesar.challenge.dao.repository.factory.IDespesasPorMesFactory;
import com.cesar.challenge.dao.view.categoria.IDespesasPorCategoria;
import com.cesar.challenge.dao.view.fonte.IDespesasPorFonteView;
import com.cesar.challenge.dao.view.mes.IDespesasPorMes;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@Import(CarregarDadosDespesas.class)
@RunWith(SpringRunner.class)
@DataJpaTest
public class DespesaRepositoryTest {

    @Autowired
    private DespesaRepository repository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void deveRetornarValorDeDespesaEsperadaQuandoConsultarDespesaApenasUmMesChamadoComParametroValido() {
        Long valorEsperado = 189958L;

        // given
        int janeiro = 1;

        // when
        Long valorRecebido = repository.consultarDespesasApenasUmMes(janeiro);

        // then
        assertEquals(valorEsperado, valorRecebido);
    }

    @Test
    public void deveRetornarIDesepesaPorMesEsperadoQuandoConsultarDespesaPorMesChamado() {

        IDespesasPorMesFactory iDespesasPorMesFactory = new IDespesasPorMesFactory();

        // given
        List<IDespesasPorMes> iDespesasPorMesConsultado = repository.consultarDespesasMesAMes();

        // when
        List<IDespesasPorMes> despesasPorMesEsperado = iDespesasPorMesFactory.getDespesasPorMesEsperado();

        // then
        assertFalse(despesasPorMesEsperado.isEmpty());
        assertFalse(iDespesasPorMesConsultado.isEmpty());
        assertEquals(despesasPorMesEsperado.get(0).getTotal(), iDespesasPorMesConsultado.get(0).getTotal());

    }

    @Test
    public void consultarDespesasAgrupadoPorCategoria() {
        IDespesasPorCategoriaFactory iDespesasPorCategoriaFactory = new IDespesasPorCategoriaFactory();

        // given
        List<IDespesasPorCategoria> iDespesasPorCategoriasConsultado = repository.consultarDespesasAgrupadoPorCategoria();

        // when
        List<IDespesasPorCategoria> despesasPorCategoriaEsperado = iDespesasPorCategoriaFactory.getDespesasPorCategoriaEsperado();

        // then
        assertFalse(despesasPorCategoriaEsperado.isEmpty());
        assertFalse(iDespesasPorCategoriasConsultado.isEmpty());
        assertEquals(despesasPorCategoriaEsperado.get(0).getCategoria_economica_nome(), iDespesasPorCategoriasConsultado.get(0).getCategoria_economica_nome());

    }

    @Test
    public void consultarDespesasAgrupadoPorFonte() {
        IDespesasPorFonteFactory iDespesasPorFonteFactory = new IDespesasPorFonteFactory();

        // given
        List<IDespesasPorFonteView> iDespesasPorFonteViewsConsultado = repository.consultarDespesasAgrupadoPorFonte();

        // when
        List<IDespesasPorFonteView> despesasPorFonteEsperado = iDespesasPorFonteFactory.getDespesasPorFonteEsperado();

        // then
        assertFalse(iDespesasPorFonteViewsConsultado.isEmpty());
        assertFalse(despesasPorFonteEsperado.isEmpty());
        assertEquals(despesasPorFonteEsperado.get(0).getFonte_recurso_nome(), iDespesasPorFonteViewsConsultado.get(0).getFonte_recurso_nome());
    }


}
