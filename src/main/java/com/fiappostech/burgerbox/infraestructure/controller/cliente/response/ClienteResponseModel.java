package com.fiappostech.burgerbox.infraestructure.controller.cliente.response;

import java.time.LocalDateTime;

public class ClienteResponseModel {
    private Long id;
    private String nome;
    private String cpf;

    private String email;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public ClienteResponseModel(
            Long id,
            String nome,
            String email,
            LocalDateTime dataCriacao,
            LocalDateTime dataAtualizacao
    ) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
