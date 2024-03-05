package com.fiappostech.burgerbox.core.entity.produto.factory;

import com.fiappostech.burgerbox.core.entity.produto.Categoria;

import java.util.List;

public class Produto {
    Long id;
    String nome;
    double preco;
    List<Categoria> categorias;

    public Produto(String nome, double preco, List<Categoria> categorias) {
        this.nome = nome;
        this.preco = preco;
        this.categorias = categorias;
    }

    public Produto(Long id, String nome, double preco, List<Categoria> categorias) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categorias = categorias;
    }

    public Produto() {

    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public double getPreco() {
        return this.preco;
    }

    public List<Categoria> getCategorias() {
        return this.categorias;
    }
}
