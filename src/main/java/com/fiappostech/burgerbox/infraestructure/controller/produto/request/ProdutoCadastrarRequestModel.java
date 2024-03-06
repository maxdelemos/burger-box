package com.fiappostech.burgerbox.infraestructure.controller.produto.request;

import java.util.List;

public class ProdutoCadastrarRequestModel {
    private String nome;
    private String descricao;
    private String imagem;
    private List<CategoriaRequestModel> categorias;
    private Double preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public List<CategoriaRequestModel> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaRequestModel> categorias) {
        this.categorias = categorias;
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
