package com.fiappostech.burgerbox.core.gateway;

import com.fiappostech.burgerbox.core.entity.pedido.PedidoPagamento;

public interface PedidoPagamentoGateway {
    PedidoPagamento cadastrar(PedidoPagamento pedido);

    PedidoPagamento buscarPorPagamentoId(Long pagamentoId);

    void atualizarPagamento(Long pedidoId);

    PedidoPagamento consultarPagamento(Long pedidoId);
}
