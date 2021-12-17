package com.payment.model.dto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class TransacoesDTO {

    private Integer idTransacao;
    @NotNull(message = "Necessario indicar qual conta sera realizado o deposito")
    private ContasDTO conta;
    @NotNull(message = "Necessario indicar um valor para o deposito")
    private BigDecimal valor;
    @NotNull(message = "Necessario indicar a data da transacao")
    private Date dataTransacao;

    public Integer getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Integer idTransacao) {
        this.idTransacao = idTransacao;
    }

    public ContasDTO getConta() {
        return conta;
    }

    public void setConta(ContasDTO conta) {
        this.conta = conta;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }
}
