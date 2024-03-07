package com.fiappostech.burgerbox.core.entity.pedido;

import java.util.List;

public interface PedidoFactory {
    Pedido create(Long id);

    Pedido create(Long ClienteId, List<PedidoItem> pedidoItem);
}
