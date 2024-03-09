package com.fiappostech.burgerbox.core.entity.produto;

import java.time.LocalDateTime;
import java.util.List;

public class ProdutoFactoryImpl implements ProdutoFactory {

    @Override
    public Produto create(
            Long id,
            String nome,
            Double preco,
            String descricao, String imagem,
            List<Categoria> categorias,
            Boolean ativo,
            LocalDateTime dataCriacao,
            LocalDateTime dataAtualizacao) {
        return new ProdutoImpl(id,
                nome,
                preco,
                descricao,
                imagem,
                categorias,
                ativo,
                dataCriacao,
                dataAtualizacao
        );
    }

    @Override
    public Produto create(
            Long id,
            String nome,
            Double preco,
            String descricao,
            String imagem,
            List<Categoria> categorias,
            LocalDateTime dataCriacao
    ) {
        return new ProdutoImpl(id,
                nome,
                preco,
                descricao,
                imagem,
                categorias,
                dataCriacao
        );
    }

    @Override
    public Produto create(String nome,
                          Double preco,
                          String descricao,
                          String imagem,
                          List<Categoria> categorias
    ) {
        return new ProdutoImpl(
                nome,
                preco,
                descricao,
                imagem,
                categorias
        );
    }

    @Override
    public Produto create(Long id, Double preco) {
        return new ProdutoImpl(id, preco);
    }
}
