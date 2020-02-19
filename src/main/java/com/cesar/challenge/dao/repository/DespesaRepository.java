package com.cesar.challenge.dao.repository;

import com.cesar.challenge.dao.model.Despesa;
import com.cesar.challenge.dao.view.categoria.IDespesasPorCategoria;
import com.cesar.challenge.dao.view.fonte.IDespesasPorFonteView;
import com.cesar.challenge.dao.view.mes.IDespesasPorMes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DespesaRepository extends CrudRepository<Despesa, Integer> {

    @Query(value = "select SUM(valor_pago) from recifeDespesas.despesa where mes_movimentacao = :mes", nativeQuery = true)
    Long consultarDespesasApenasUmMes(@Param("mes") Integer mes);

    @Query(value = "select mes_movimentacao , SUM(valor_pago) as total from recifeDespesas.despesa group by mes_movimentacao order by mes_movimentacao;", nativeQuery = true)
    List<IDespesasPorMes> consultarDespesasMesAMes();

    @Query(value="select categoria_economica_nome, SUM(valor_pago) as total from recifeDespesas.despesa group by categoria_economica_nome order by categoria_economica_nome", nativeQuery =true )
    List<IDespesasPorCategoria> consultarDespesasAgrupadoPorCategoria();


    @Query(value="select fonte_recurso_nome, SUM(valor_pago) as total from recifeDespesas.despesa group by fonte_recurso_nome order by fonte_recurso_nome;", nativeQuery =true )
    List<IDespesasPorFonteView> consultarDespesasAgrupadoPorFonte();


}
