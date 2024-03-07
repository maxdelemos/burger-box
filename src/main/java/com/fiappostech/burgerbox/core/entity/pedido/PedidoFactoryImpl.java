package com.fiappostech.burgerbox.core.entity.pedido;

import java.util.List;

public class PedidoFactoryImpl implements PedidoFactory {
    @Override
    public Pedido create(Long id) {
        return new PedidoImpl(id);
    }

    @Override
    public Pedido create(Long ClienteId, List<PedidoItem> pedidoItem) {
        return new PedidoImpl(ClienteId, pedidoItem);
    }
}
