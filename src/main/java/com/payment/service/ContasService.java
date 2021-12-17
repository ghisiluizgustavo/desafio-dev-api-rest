package com.payment.service;

import com.payment.model.Contas;
import com.payment.model.Transacoes;
import com.payment.model.dto.ContasDTO;
import com.payment.repository.ContasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class ContasService {

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ContasRepository contasRepository;

    public ResponseEntity<ContasDTO> criarConta(ContasDTO contaDTO, UriComponentsBuilder uriBuilder) {
        Contas conta = modelMapper.map(contaDTO, Contas.class);
        Contas contaSalva = contasRepository.save(conta);
        ContasDTO contaSalvaDTO = modelMapper.map(contaSalva, ContasDTO.class);
        URI uri = uriBuilder.path("/api/contas/{id}").buildAndExpand(contaSalvaDTO.getIdConta()).toUri();
        return ResponseEntity.created(uri).body(contaSalvaDTO);
    }

    public boolean atualizarSaldo(Transacoes transacao) {
        Optional<Contas> contaOptional = contasRepository.findById(transacao.getConta().getIdConta());
        final boolean[] retorno = {false};
        contaOptional.ifPresent(
                conta -> {
                    BigDecimal saldo = conta.getSaldo();
                    conta.setSaldo(saldo.add(transacao.getValor()));
                    contasRepository.save(conta);
                    retorno[0] = true;
                });
        return retorno[0];
    }

    public ResponseEntity<Double> consultarSaldo(Integer idConta) {
        BigDecimal saldo = contasRepository.findSaldoById(idConta);
        return ResponseEntity.ok(saldo.doubleValue());
    }

    public ResponseEntity<ContasDTO> bloquearConta(Integer idConta) {
        Optional<Contas> contasOptional = contasRepository.findById(idConta);
        if (contasOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Contas conta = contasOptional.get();
        conta.setFlagAtivo(false);
        ContasDTO contaDTO = modelMapper.map(conta, ContasDTO.class);
        return ResponseEntity.ok(contaDTO);
    }
}
