package com.payment.model.dto;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;

public class ContasDTO {

    private Integer idConta;
    @NotNull(message = "Necessario informar a quem a conta esta vinculada")
    private PessoasDTO pessoa;
    private BigDecimal saldo;
    private BigDecimal limiteSaqueDiario;
    @NotNull(message = "Necessario informar se esta ativa ou nao")
    private Boolean flagAtivo;
    @NotNull(message = "Necessario informar qual tipo da conta")
    private Integer tipoConta;
    private Date dataCriacao;

    public boolean isEmpty(){
        Class<ContasDTO> contasDTOClass = ContasDTO.class;
        Field[] campos = contasDTOClass.getDeclaredFields();
        for (Field campo : campos){
            campo.setAccessible(true);
            try {
                Object objeto = campo.get(this);
                if(objeto != null) return false;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public PessoasDTO getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoasDTO pessoa) {
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
}
