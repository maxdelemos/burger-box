package com.fiappostech.burgerbox.core.entity.cliente;

import java.time.LocalDateTime;

public class ClienteImpl implements Cliente {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private LocalDateTime dataAtualizacao;
    private LocalDateTime dataCriacao;

    public ClienteImpl(Long id, String nome, String email, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public ClienteImpl(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public ClienteImpl(String cpf) {
        this.cpf = cpf;
    }

    public ClienteImpl(Long id, String cpf, LocalDateTime dataAtualizacao, LocalDateTime dataCriacao) {
        this.id = id;
        this.cpf = cpf;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public ClienteImpl(Long id, String nome, String cpf, String email, LocalDateTime dataAtualizacao, LocalDateTime dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public String getCpf() {
        return this.cpf;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public LocalDateTime getDataCriacao() {
        return this.dataCriacao;
    }

    @Override
    public LocalDateTime getDataAtualizacao() {
        return this.dataAtualizacao;
    }
}
