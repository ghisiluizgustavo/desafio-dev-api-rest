package com.payment.service;

import com.payment.model.Contas;
import com.payment.model.Transacoes;
import com.payment.model.dto.ContasDTO;
import com.payment.model.dto.TransacoesDTO;
import com.payment.repository.ContasRepository;
import com.payment.repository.TransacoesRepository;
import com.payment.util.TransacaoEnum;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransacoesService {

    @Autowired
    private TransacoesRepository transacoesRepository;
    @Autowired
    private ContasRepository contasRepository;
    @Autowired
    private ContasService contasService;
    private ModelMapper modelMapper = new ModelMapper();

    private final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public ResponseEntity<TransacoesDTO> realizarTransacao(TransacoesDTO transacaoDTO, TransacaoEnum transacaoEnum){
        Transacoes transacao = modelMapper.map(transacaoDTO, Transacoes.class);

        if (!verificarFlagAtiva(transacao.getConta().getIdConta())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        if (transacaoEnum.equals(TransacaoEnum.SAQUE)) {
            transacao.setValor(transacao.getValor().negate());

            if(verificarSaldo(transacao))
                return ResponseEntity.badRequest().build();
        }

        Transacoes transacaoSalva = transacoesRepository.save(transacao);
        TransacoesDTO transacaoSalvaDTO = modelMapper.map(transacaoSalva, TransacoesDTO.class);
        contasService.atualizarSaldo(transacaoSalva);

        return ResponseEntity.ok(transacaoSalvaDTO);
    }

    private boolean verificarSaldo(Transacoes transacao) {
        BigDecimal saldo = contasRepository.findSaldoById(transacao.getConta().getIdConta());
        return transacao.getValor().compareTo(saldo) > 0;
    }

    private boolean verificarFlagAtiva(Integer idConta){
        Optional<Contas> contasOptional = contasRepository.findById(idConta);
        if(contasOptional.isEmpty()){
            return false;
        }
        if(!contasOptional.get().getFlagAtivo()){
            return false;
        }
        return true;
    }

    public ResponseEntity<List<TransacoesDTO>> extratoContaPorPeriodo(Integer idConta, String dataInicio, String dataFim) throws ParseException {
        Optional<Contas> contaOpt = contasRepository.findById(idConta);
        if(contaOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Contas conta = contaOpt.get();

        Date dataInicioDateFormat, dataFimDateFormat;

        if(dataInicio != null && dataFim != null){
            dataInicioDateFormat = format.parse(dataInicio);
            dataFimDateFormat = format.parse(dataFim);
        } else {
            dataInicioDateFormat = conta.getDataCriacao();
            dataFimDateFormat = new Date();
        }

        Optional<List<Transacoes>> transacoes = transacoesRepository.findAllTransacoesByContaIdAndIntervalDate(conta, dataInicioDateFormat, dataFimDateFormat);
        if (transacoes.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        List<TransacoesDTO> transacoesDTOS = new ArrayList<>();
        for (Transacoes transacao : transacoes.get()){
            transacao.setConta(null);
            transacoesDTOS.add(modelMapper.map(transacao, TransacoesDTO.class));
        }
        return ResponseEntity.ok(transacoesDTOS);
    }
}
