package com.fiappostech.burgerbox.core.entity.produto;

import java.time.LocalDateTime;
import java.util.List;

public interface ProdutoFactory {
    Produto create(
            Long id,
            String nome,
            Double preco,
            String descricao,
            String imagem,
            List<Categoria> categorias,
            Boolean ativo,
            LocalDateTime dataCriacao,
            LocalDateTime dataAtualizacao
    );

    Produto create(
            Long id,
            String nome,
            Double preco,
            String descricao,
            String imagem,
            List<Categoria> categorias,
            LocalDateTime dataCriacao
    );

    Produto create(
            String nome,
            Double preco,
            String descricao,
            String imagem,
            List<Categoria> categorias
    );

    Produto create(
            Long id,
            Double preco
    );
}
