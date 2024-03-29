package com.fiappostech.burgerbox.core.usecase.produto;

import com.fiappostech.burgerbox.infraestructure.controller.produto.request.ProdutoRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.produto.response.ProdutoResponseModel;

public interface EditarProdutoBoundary {
    ProdutoResponseModel execute(Long id, ProdutoRequestModel produtoResponseModel);
}
