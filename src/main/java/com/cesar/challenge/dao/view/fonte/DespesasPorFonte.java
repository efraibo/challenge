package com.cesar.challenge.dao.view.fonte;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DespesasPorFonte {

    private String fonte_recurso_nome;
    private Double total;
}
