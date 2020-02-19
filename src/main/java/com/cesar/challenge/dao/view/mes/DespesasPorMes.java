package com.cesar.challenge.dao.view.mes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DespesasPorMes {

    private Integer mes_movimento;
    private Double total;
}
