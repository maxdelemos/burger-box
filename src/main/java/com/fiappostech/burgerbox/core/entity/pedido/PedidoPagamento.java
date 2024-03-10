package com.fiappostech.burgerbox.core.entity.pedido;

public interface PedidoPagamento {
    Long getId();

    Long getPedidoId();

    Long getPagamentoId();

    String getStatus();
}
