package com.fiappostech.burgerbox.core.entity.cliente;

public class ClienteImpl implements Cliente {
    private final Long id;
    private final String nome;
    private final String cpf;

    public ClienteImpl(Long id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
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
}
