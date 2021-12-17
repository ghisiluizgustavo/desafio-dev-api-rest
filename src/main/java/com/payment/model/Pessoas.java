package com.payment.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Pessoas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPessoa;
    private String nome;
    @Column(length = 11)
    private String cpf;
    private Date dataNascimento;

    public Pessoas() {
    }

    public Pessoas(Integer idPessoa, String nome, String cpf, Date dataNascimento) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Pessoas{" +
                "idPessoa=" + idPessoa +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}