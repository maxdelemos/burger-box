package com.fiappostech.burgerbox.core.usecase.pedido;

import com.fiappostech.burgerbox.infraestructure.controller.pedido.request.PedidoRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.response.PedidoResponseModel;

public interface CadastrarPedidoBoundary {
    PedidoResponseModel execute(PedidoRequestModel pedidoRequestModel);
}
