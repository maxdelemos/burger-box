package com.fiappostech.burgerbox.infraestructure.controller.produto.response;

public interface ProdutoPresenter {
    ProdutoResponseModel prepareSuccessView(ProdutoResponseModel produtoResponseModel);

    ProdutoResponseModel prepareFailView(String error);
}
