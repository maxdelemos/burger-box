package com.fiappostech.burgerbox.infraestructure.controller.pedido.response;

import java.util.List;

public interface ListaPedidoPresenter {
    List<ListaPedidoResponseModel> prepareSuccessView(List<ListaPedidoResponseModel> produtoResponseModel);
    ListaPedidoResponseModel prepareFailView(String error);
}
