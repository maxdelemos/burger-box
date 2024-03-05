package com.fiappostech.burgerbox.infraestructure.controller.produto.response;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ProdutoResponseFormatter implements ProdutoPresenter {
    @Override
    public ProdutoResponseModel prepareSuccessView(ProdutoResponseModel produtoResponseModel) {
        return produtoResponseModel;
    }

    @Override
    public ProdutoResponseModel prepareFailView(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }
}
