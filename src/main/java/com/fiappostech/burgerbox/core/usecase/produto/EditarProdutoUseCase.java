package com.fiappostech.burgerbox.core.usecase.produto;

import com.fiappostech.burgerbox.core.entity.produto.factory.Produto;

public interface EditarProdutoUseCase {
    Produto execute(Produto produtoDomain);
}