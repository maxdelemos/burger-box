package com.fiappostech.burgerbox.core.gateway;

import com.fiappostech.burgerbox.core.entity.produto.Produto;

public interface ProdutoGateway {
    Produto cadastrar(Produto produto);

    Produto editar(Produto produto);

    void remover(Long id);

    Boolean existePorNomeAtivo(String nome);

    Produto buscarPorIdAtivo(Long id);
}
