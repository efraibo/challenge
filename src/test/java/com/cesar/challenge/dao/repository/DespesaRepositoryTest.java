package com.cesar.challenge.dao.repository;

import com.cesar.challenge.dao.model.Despesa;
import com.cesar.challenge.dao.view.mes.DespesasPorMes;
import com.cesar.challenge.dao.view.mes.IDespesasPorMes;
import com.cesar.challenge.model.ListaDespesas;
import org.junit.Assert;
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

import static org.assertj.core.api.Assertions.assertThat;

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

        Assert.assertEquals(valorAtual, valorEsperado);
    }

    @Test
    public void consultarDespesasMesAMes() {
        List<IDespesasPorMes> iDespesasPorMes = repository.consultarDespesasMesAMes();

        List<DespesasPorMes> listaDepesasPorMesEsperada = iDespesasPorMes
                .stream()
                .map(despesaView -> new DespesasPorMes(despesaView.getMes_movimentacao(), despesaView.getTotal()))
                .collect(Collectors.toList());


    }


    @Test
    public void consultarDespesasAgrupadoPorCategoria() {
    }

    @Test
    public void consultarDespesasAgrupadoPorFonte() {
    }


}
