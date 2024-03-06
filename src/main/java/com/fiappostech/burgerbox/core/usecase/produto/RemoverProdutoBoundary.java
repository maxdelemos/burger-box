package com.fiappostech.burgerbox.core.usecase.produto;

import com.fiappostech.burgerbox.infraestructure.controller.produto.response.ProdutoResponseModel;

public interface RemoverProdutoBoundary {
    ProdutoResponseModel execute(Long id);
}
