package com.fiappostech.burgerbox.infraestructure.controller.pedido.response;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AtualizarPedidoResponseFormatter implements AtualizarPedidoPresenter {
    @Override
    public AtualizarPedidoResponseModel prepareFailView(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }

    @Override
    public AtualizarPedidoResponseModel prepareSuccessView(AtualizarPedidoResponseModel atualizarPedidoResponseModel) {
        return atualizarPedidoResponseModel;
    }
}
