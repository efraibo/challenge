package com.cesar.challenge.dao.repository;

import com.cesar.challenge.dao.model.Despesa;
import com.cesar.challenge.dao.view.categoria.DespesasPorCategoria;
import com.cesar.challenge.dao.view.categoria.IDespesasPorCategoria;
import com.cesar.challenge.dao.view.fonte.DespesasPorFonte;
import com.cesar.challenge.dao.view.fonte.IDespesasPorFonteView;
import com.cesar.challenge.dao.view.mes.DespesasPorMes;
import com.cesar.challenge.dao.view.mes.IDespesasPorMes;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DespesaRepositoryTest {

    @Autowired
    private DespesaRepository repository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Despesa getDespesa() {
        return Despesa.builder()
                .acaoNome("ASSESSORAMENTO GOVERNAMENTAL")
                .anoMovimentacao(2019)
                .credorNome("CREDOR NÃO INFORMADO")
                .build();
    }

    @Test
    public void consultarDespesasApenasUmMes() {


        Long valorEsperado = repository.consultarDespesasApenasUmMes(1);
        Long valorAtual = 189958L;
        assertNotNull(repository.consultarDespesasApenasUmMes(1));
        assertEquals(valorAtual, valorEsperado);
    }

    @Test
    public void consultarDespesasMesAMes() {
        List<IDespesasPorMes> iDespesasPorMes = repository.consultarDespesasMesAMes();
        assertNotNull(repository.consultarDespesasMesAMes());
        List<DespesasPorMes> listaDepesasPorMesEsperada = iDespesasPorMes
                .stream()
                .map(despesaView -> new DespesasPorMes(despesaView.getMes_movimentacao(), despesaView.getTotal()))
                .collect(Collectors.toList());

        List<DespesasPorMes> listaDespesasPorMesAtual = getDespesasPorMes();

        assertEquals(listaDepesasPorMesEsperada, listaDespesasPorMesAtual);

    }

    @Test
    public void consultarDespesasAgrupadoPorCategoria() {
        List<IDespesasPorCategoria> iDespesasPorCategorias = repository.consultarDespesasAgrupadoPorCategoria();
        assertNotNull(repository.consultarDespesasAgrupadoPorCategoria());
        List<DespesasPorCategoria> listaDepesasPorMesEsperado = iDespesasPorCategorias
                .stream()
                .map(despesaView -> new DespesasPorCategoria(despesaView.getCategoria_economica_nome(), despesaView.getTotal()))
                .collect(Collectors.toList());
        List<DespesasPorCategoria> listaDepesasPorMesAtual =
                Arrays.asList(DespesasPorCategoria.builder().categoria_economica_nome("DESPESAS CORRENTES").total(4186958.8899999983).build());
        assertEquals(listaDepesasPorMesEsperado, listaDepesasPorMesAtual);
    }

    @Test
    public void consultarDespesasAgrupadoPorFonte() {
        List<IDespesasPorFonteView> iDespesasPorCategorias = repository.consultarDespesasAgrupadoPorFonte();
        assertNotNull(repository.consultarDespesasAgrupadoPorFonte());
        List<DespesasPorFonte> listaDepesasPorMesEsperado = iDespesasPorCategorias
                .stream()
                .map(despesaView -> new DespesasPorFonte(despesaView.getFonte_recurso_nome(), despesaView.getTotal()))
                .collect(Collectors.toList());

        List<DespesasPorFonte> listaDepesasPorMesEsperadoAtual = Arrays.asList(DespesasPorFonte.builder()
                .fonte_recurso_nome("RECURSOS ORDINÁRIOS - NÃO VINCULADOS").total(4186958.8899999983).build());

        assertEquals(listaDepesasPorMesEsperado, listaDepesasPorMesEsperadoAtual);
    }

    private List<DespesasPorMes> getDespesasPorMes() {
        return Arrays.asList(
                DespesasPorMes.builder().mes_movimento(1).total(189958.01).build(),
                DespesasPorMes.builder().mes_movimento(2).total(909544.6799999999).build(),
                DespesasPorMes.builder().mes_movimento(3).total(134110.19999999998).build(),
                DespesasPorMes.builder().mes_movimento(4).total(100603.17000000001).build(),
                DespesasPorMes.builder().mes_movimento(5).total(177984.94999999998).build(),
                DespesasPorMes.builder().mes_movimento(6).total(112281.23999999999).build(),
                DespesasPorMes.builder().mes_movimento(7).total(155754.14).build(),
                DespesasPorMes.builder().mes_movimento(8).total(1112424.1).build(),
                DespesasPorMes.builder().mes_movimento(9).total(165121.13).build(),
                DespesasPorMes.builder().mes_movimento(10).total(231361.59999999998).build(),
                DespesasPorMes.builder().mes_movimento(11).total(129987.51).build(),
                DespesasPorMes.builder().mes_movimento(12).total(767828.1599999999).build());
    }

}
