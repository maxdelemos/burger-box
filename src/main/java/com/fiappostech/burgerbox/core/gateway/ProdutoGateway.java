package com.fiappostech.burgerbox.core.gateway;

import com.fiappostech.burgerbox.core.entity.produto.factory.Produto;

public interface ProdutoGateway {
    Produto cadastrar(Produto produtoCommon);
    Produto editar(Produto produto);
    Produto remover(Produto produto);
    Boolean existe(String nome);
}
