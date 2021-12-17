package com.payment.controller;

import com.payment.model.Transacoes;
import com.payment.model.dto.ContasDTO;
import com.payment.model.dto.TransacoesDTO;
import com.payment.service.ContasService;
import com.payment.service.TransacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/contas")
public class ContasController {

    @Autowired
    private ContasService contasService;
    @Autowired
    private TransacoesService transacoesService;

    @GetMapping("/saldo/{idConta}")
    public ResponseEntity<Double> consultarSaldo(@PathVariable Integer idConta){
        return contasService.consultarSaldo(idConta);
    }

    @PostMapping("/criar")
    public ResponseEntity<ContasDTO> criarConta(@RequestBody @Valid ContasDTO contaDTO, UriComponentsBuilder uriBuilder, Errors error) {
        return contasService.criarConta(contaDTO, uriBuilder);
    }

    @PutMapping("/bloquear/{idConta}")
    public ResponseEntity<ContasDTO> bloquearConta(@PathVariable Integer idConta){
        return contasService.bloquearConta(idConta);
    }

    @GetMapping("/extrato/{idConta}")
    public ResponseEntity<List<TransacoesDTO>> extrato(@PathVariable Integer idConta){
        return transacoesService.extratoConta(idConta);
    }
}
