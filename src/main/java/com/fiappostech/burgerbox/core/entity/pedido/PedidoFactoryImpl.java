package com.fiappostech.burgerbox.core.entity.pedido;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoFactoryImpl implements PedidoFactory {
    @Override
    public Pedido create(Long id, String status, List<PedidoItem> pedidoItems, LocalDateTime dataAtualizacao) {
        return new PedidoImpl(id, status, pedidoItems, dataAtualizacao);
    }

    @Override
    public Pedido create(Long id, String status, LocalDateTime dataAtualizacao) {
        return new PedidoImpl(id, status, dataAtualizacao);
    }

    @Override
    public Pedido create(Long id, String status) {
        return new PedidoImpl(id, status);
    }

    @Override
    public Pedido create(Long clienteId, List<PedidoItem> pedidoItem) {
        return new PedidoImpl(clienteId, pedidoItem);
    }
}
