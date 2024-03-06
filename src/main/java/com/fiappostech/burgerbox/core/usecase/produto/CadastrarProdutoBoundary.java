package com.fiappostech.burgerbox.core.usecase.produto;

import com.fiappostech.burgerbox.infraestructure.controller.produto.request.ProdutoCadastrarRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.produto.response.ProdutoResponseModel;

public interface CadastrarProdutoBoundary {
    ProdutoResponseModel execute(ProdutoCadastrarRequestModel produtoCadastrarRequestModel);
}
