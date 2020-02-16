package com.cesar.challenge.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/despesas")
@Api(value = "API REST Despesas")
@CrossOrigin(origins = "*")
public class DespesaController {

    @GetMapping
    public String getDespesasTotaisPorMes() {
        return "Retorno do metodo getUser - HTTP GET";
    }

    @PostMapping
    public String createDespesa() {
        return "Retorno do metodo createUser - HTTP POST";
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
