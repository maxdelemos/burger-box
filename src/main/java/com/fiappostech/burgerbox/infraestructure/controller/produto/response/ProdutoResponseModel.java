package com.fiappostech.burgerbox.infraestructure.controller.produto.response;

import java.time.LocalDateTime;
import java.util.List;

public class ProdutoResponseModel {
    private Long id;
    private String nome;
    private String descricao;
    private String imagem;
    private List<CategoriaResponseModel> categorias;
    private double preco;
    private Boolean ativo;
    private LocalDateTime dataCricao;
    private LocalDateTime dataAtualizacao;

    public ProdutoResponseModel(Long id, String nome, String descricao, String imagem, List<CategoriaResponseModel> categorias, double preco, Boolean ativo, LocalDateTime dataCricao, LocalDateTime dataAtualizacao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.imagem = imagem;
        this.categorias = categorias;
        this.preco = preco;
        this.ativo = ativo;
        this.dataCricao = dataCricao;
        this.dataAtualizacao = dataAtualizacao;
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

    public List<CategoriaResponseModel> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaResponseModel> categorias) {
        this.categorias = categorias;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataCricao() {
        return dataCricao;
    }

    public void setDataCricao(LocalDateTime dataCricao) {
        this.dataCricao = dataCricao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
