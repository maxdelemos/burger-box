package com.fiappostech.burgerbox.core.gateway;

import com.fiappostech.burgerbox.core.entity.pedido.MPPagamento;

public interface MercadoPagoGateway {
    MPPagamento gerarPagamento(Double valor);
    Object consultarPagamento(Long id);
}
