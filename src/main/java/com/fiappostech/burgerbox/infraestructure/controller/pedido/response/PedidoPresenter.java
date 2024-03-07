package com.fiappostech.burgerbox.infraestructure.controller.pedido.response;

public interface PedidoPresenter {
    PedidoResponseModel prepareSuccessView(PedidoResponseModel produtoResponseModel);

    PedidoResponseModel prepareFailView(String error);
}
