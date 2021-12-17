package com.payment.controller;

import com.payment.model.Contas;
import com.payment.service.ContasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contas")
public class ContasController {

    @Autowired
    private ContasService contasService;

    @GetMapping
    public List<Contas> buscarTodasContas(){
        return contasService.buscarTodasContas();
    }
}
