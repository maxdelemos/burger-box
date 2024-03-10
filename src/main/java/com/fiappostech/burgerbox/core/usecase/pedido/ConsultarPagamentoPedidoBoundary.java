package com.fiappostech.burgerbox.core.usecase.pedido;

import com.fiappostech.burgerbox.infraestructure.controller.pedido.response.ConsultarPagamentoResponseModel;

public interface ConsultarPagamentoPedidoBoundary {
    ConsultarPagamentoResponseModel execute(Long pedidoId);
}
