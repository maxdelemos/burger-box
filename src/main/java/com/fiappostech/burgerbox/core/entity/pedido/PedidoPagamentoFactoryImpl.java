package com.fiappostech.burgerbox.core.entity.pedido;

public class PedidoPagamentoFactoryImpl implements PedidoPagamentoFactory {
    @Override
    public PedidoPagamento create(Long id, Long pedidoId, Long pagamentoId, String status) {
        return new PedidoPagamentoImpl(id, pedidoId, pagamentoId, status);
    }

    @Override
    public PedidoPagamento create(Long id, String status) {
        return new PedidoPagamentoImpl(id, status);
    }
}
