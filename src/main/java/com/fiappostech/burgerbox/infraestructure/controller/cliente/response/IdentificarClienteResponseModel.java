package com.fiappostech.burgerbox.infraestructure.controller.cliente.response;

public class IdentificarClienteResponseModel {
    private Long id;
    private String nome;
    private String cpf;
    private String email;

    public IdentificarClienteResponseModel(Long id, String nome, String cpf, String email) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
