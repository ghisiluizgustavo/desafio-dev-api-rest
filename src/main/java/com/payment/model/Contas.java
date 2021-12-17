package com.payment.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Contas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConta;
    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoas pessoa;
    private BigDecimal saldo;
    private BigDecimal limiteSaqueDiario;
    private Boolean flagAtivo;
    private Integer tipoConta;
    private Date dataCriacao;

    public Contas() {
    }

    public Contas(Integer idConta, Pessoas pessoa, BigDecimal saldo, BigDecimal limiteSaqueDiario, Boolean flagAtivo, Integer tipoConta, Date dataCriacao) {
        this.idConta = idConta;
        this.pessoa = pessoa;
        this.saldo = saldo;
        this.limiteSaqueDiario = limiteSaqueDiario;
        this.flagAtivo = flagAtivo;
        this.tipoConta = tipoConta;
        this.dataCriacao = dataCriacao;
    }

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public Pessoas getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoas pessoa) {
        this.pessoa = pessoa;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getLimiteSaqueDiario() {
        return limiteSaqueDiario;
    }

    public void setLimiteSaqueDiario(BigDecimal limiteSaqueDiario) {
        this.limiteSaqueDiario = limiteSaqueDiario;
    }

    public Boolean getFlagAtivo() {
        return flagAtivo;
    }

    public void setFlagAtivo(Boolean flagAtivo) {
        this.flagAtivo = flagAtivo;
    }

    public Integer getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(Integer tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        return "Contas{" +
                "idConta=" + idConta +
                ", pessoa=" + pessoa +
                ", saldo=" + saldo +
                ", limiteSaqueDiario=" + limiteSaqueDiario +
                ", flagAtivo=" + flagAtivo +
                ", tipoConta=" + tipoConta +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}
