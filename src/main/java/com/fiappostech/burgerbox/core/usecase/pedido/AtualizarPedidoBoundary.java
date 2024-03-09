package com.fiappostech.burgerbox.core.usecase.pedido;

import com.fiappostech.burgerbox.infraestructure.controller.pedido.request.AtualizarStatusPedidoRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.response.AtualizarPedidoResponseModel;

public interface AtualizarPedidoBoundary {
    AtualizarPedidoResponseModel execute(Long id, AtualizarStatusPedidoRequestModel atualizarStatusPedidoRequestModel);
}
