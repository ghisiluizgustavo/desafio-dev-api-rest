package com.payment.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Transacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTransacao;
    @ManyToOne
    @JoinColumn(name = "id_conta")
    private Contas conta;
    private BigDecimal valor;
    private Date dataTransacao;

    public Transacoes() {
    }

    public Transacoes(Integer idTransacao, Contas conta, BigDecimal valor, Date dataTransacao) {
        this.idTransacao = idTransacao;
        this.conta = conta;
        this.valor = valor;
        this.dataTransacao = dataTransacao;
    }

    public Integer getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Integer idTransacao) {
        this.idTransacao = idTransacao;
    }

    public Contas getConta() {
        return conta;
    }

    public void setConta(Contas conta) {
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

    @Override
    public String toString() {
        return "Transacoes{" +
                "idTransacao=" + idTransacao +
                ", conta=" + conta +
                ", valor=" + valor +
                ", dataTransacao=" + dataTransacao +
                '}';
    }
}
