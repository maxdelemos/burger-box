package com.fiappostech.burgerbox.core.entity.produto;

import java.time.LocalDateTime;
import java.util.List;

public class ProdutoImpl implements Produto {
    Long id;
    String nome;
    Double preco;
    Boolean ativo;
    String descricao;
    String imagem;
    List<Categoria> categorias;
    LocalDateTime dataCriacao;
    LocalDateTime dataAtualizacao;

    public ProdutoImpl(
            Long id,
            String nome,
            Double preco,
            String descricao,
            String imagem,
            List<Categoria> categorias,
            Boolean ativo,
            LocalDateTime dataCriacao,
            LocalDateTime dataAtualizacao
    ) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.imagem = imagem;
        this.categorias = categorias;
        this.ativo = ativo;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public ProdutoImpl(
            Long id,
            String nome,
            Double preco,
            String descricao,
            String imagem,
            List<Categoria> categorias,
            LocalDateTime dataCriacao
    ) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.imagem = imagem;
        this.categorias = categorias;
        this.dataCriacao = dataCriacao;
    }

    public ProdutoImpl(
            String nome,
            Double preco,
            String descricao,
            String imagem,
            List<Categoria> categorias
    ) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.imagem = imagem;
        this.categorias = categorias;
    }

    public ProdutoImpl(Long id, Boolean ativo) {
        this.id = id;
        this.ativo = ativo;
    }

    public ProdutoImpl(Long id, Double preco) {
        this.id = id;
        this.preco = preco;
    }

    public ProdutoImpl(Long id) {
        this.id = id;
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
    public Double getPreco() {
        return this.preco;
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public String getImagem() {
        return this.imagem;
    }

    @Override
    public Boolean getAtivo() {
        return this.ativo;
    }

    @Override
    public List<Categoria> getCategorias() {
        return this.categorias;
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
