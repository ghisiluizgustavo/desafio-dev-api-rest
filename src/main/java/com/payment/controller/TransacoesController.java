package com.payment.controller;

import com.payment.model.dto.TransacoesDTO;
import com.payment.service.TransacoesService;
import com.payment.util.TransacaoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/transacoes")
public class TransacoesController {

    @Autowired
    private TransacoesService transacoesService;

    @PostMapping("/deposito")
    public ResponseEntity<TransacoesDTO> deposito(@RequestBody @Valid TransacoesDTO transacaoDTO) {
        return transacoesService.realizarTransacao(transacaoDTO, TransacaoEnum.DEPOSITO);
    }

    @PostMapping("/saque")
    public ResponseEntity<TransacoesDTO> saque(@RequestBody @Valid TransacoesDTO transacaoDTO) {
        return transacoesService.realizarTransacao(transacaoDTO, TransacaoEnum.SAQUE);
    }
}
