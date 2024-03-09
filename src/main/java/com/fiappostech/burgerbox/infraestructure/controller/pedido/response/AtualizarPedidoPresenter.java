package com.fiappostech.burgerbox.infraestructure.controller.pedido.response;

public interface AtualizarPedidoPresenter {
    AtualizarPedidoResponseModel prepareSuccessView(AtualizarPedidoResponseModel atualizarPedidoResponseModel);
    AtualizarPedidoResponseModel prepareFailView(String error);
}
