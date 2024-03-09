package com.fiappostech.burgerbox.infraestructure.controller.pedido.response;

public interface PedidoPresenter {
    PedidoResponseModel prepareSuccessView(PedidoResponseModel produtoResponseModel);

    AtualizarPedidoResponseModel prepareSuccessView(AtualizarPedidoResponseModel produtoResponseModel);

    PedidoResponseModel prepareFailView(String error);
}
