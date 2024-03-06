package com.fiappostech.burgerbox.core.gateway;

import com.fiappostech.burgerbox.core.entity.produto.Produto;

import java.util.List;

public interface ProdutoGateway {
    Produto cadastrar(Produto produto);

    Produto editar(Produto produto);

    void remover(Long id);

    Boolean existePorNomeAtivo(String nome);

    Produto buscarPorIdAtivo(Long id);

    List<Produto> buscarPorIdsAtivo(List<Long> ids);
}
