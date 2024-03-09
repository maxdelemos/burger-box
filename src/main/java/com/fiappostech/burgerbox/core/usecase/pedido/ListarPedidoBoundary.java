package com.fiappostech.burgerbox.core.usecase.pedido;

import com.fiappostech.burgerbox.infraestructure.controller.pedido.response.ListaPedidoResponseModel;

import java.util.List;

public interface ListarPedidoBoundary {
    List<ListaPedidoResponseModel> execute();
}
