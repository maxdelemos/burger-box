package com.fiappostech.burgerbox.infraestructure.controller.pedido.response;

import com.fiappostech.burgerbox.infraestructure.controller.produto.response.ProdutoPresenter;
import com.fiappostech.burgerbox.infraestructure.controller.produto.response.ProdutoResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PedidoResponseFormatter implements PedidoPresenter {
    @Override
    public PedidoResponseModel prepareSuccessView(PedidoResponseModel produtoResponseModel) {
        return produtoResponseModel;
    }

    @Override
    public PedidoResponseModel prepareFailView(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }
}
