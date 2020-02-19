package com.cesar.challenge.controller;

import com.cesar.challenge.dao.view.categoria.DespesasPorCategoria;
import com.cesar.challenge.dao.view.fonte.DespesasPorFonte;
import com.cesar.challenge.dao.view.mes.DespesasPorMes;
import com.cesar.challenge.services.DespesasService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/despesas")
@Api(value = "API REST Despesas")
@CrossOrigin(origins = "*")
public class DespesaController {

    @Autowired
    private DespesasService despesasService;

    @GetMapping(path = "/mes")
    public List<DespesasPorMes> getDespesasTotaisPorMes() {
        return despesasService.consultarDespesasPorMes();
    }

    @GetMapping(path = "/categoria")
    public List<DespesasPorCategoria> getDespesasTotaisPorCategoria() {
        return despesasService.consultarDespesasPorCategoria();
    }

    @GetMapping(path = "/fonte")
    public List<DespesasPorFonte> getDespesasTotaisPorFonte() {
        return despesasService.consultarDespesasPorFonte();
    }

    @PutMapping
    public String updateDespesa() {
        return "Retorno do metodo updateUser - HTTP PUT";
    }

    @DeleteMapping
    public String deleteDespesa() {
        return "Retorno do metodo deleteUser - HTTP DELETE";
    }

}
