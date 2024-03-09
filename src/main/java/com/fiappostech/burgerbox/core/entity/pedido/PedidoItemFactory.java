package com.fiappostech.burgerbox.core.entity.pedido;

public interface PedidoItemFactory {
    PedidoItem create(Long id, Integer quantidade);
    PedidoItem create(Long id, Integer quantidade, Double valor);
}
