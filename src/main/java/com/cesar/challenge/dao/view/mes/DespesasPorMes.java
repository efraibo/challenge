package com.cesar.challenge.dao.view.mes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class DespesasPorMes {

    private Integer mes_movimento;
    private Double total;
}
