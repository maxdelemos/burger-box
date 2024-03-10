package com.fiappostech.burgerbox.core.entity.pedido;

public interface PedidoPagamentoFactory {
    PedidoPagamento create(Long id, Long pedidoId, Long pagamentoId, String status);
    PedidoPagamento create(Long id, String status);
}
