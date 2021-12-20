package com.payment.controller.swagger;

import com.payment.model.dto.ContasDTO;
import com.payment.model.dto.TransacoesDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

public interface ContasInterface {

    @ApiOperation("Path que retorna o saldo de uma conta com base no id da conta passado na URL")
    ResponseEntity<Double> consultarSaldo(@PathVariable Integer idConta);

    @ApiOperation("Path que cria conta baseado no json enviado no body da requisição")
    ResponseEntity<ContasDTO> criarConta(@RequestBody @Valid ContasDTO contaDTO, UriComponentsBuilder uriBuilder, Errors error);

    @ApiOperation("Path que bloqueia uma conta baseado no id da conta passado na URL")
    ResponseEntity<ContasDTO> bloquearConta(@PathVariable Integer idConta);

    @ApiOperation("Path que consulta extrato de transações de uma conta baseado no id passado na URL")
    ResponseEntity<List<TransacoesDTO>> extratoPorPeriodo(@PathVariable Integer idConta,
                                                          @RequestParam(required = false) String dataInicio,
                                                          @RequestParam(required = false) String dataFim) throws ParseException;
}
