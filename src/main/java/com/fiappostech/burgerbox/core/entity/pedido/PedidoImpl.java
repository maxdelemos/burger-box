package com.fiappostech.burgerbox.core.entity.pedido;

import java.util.List;

public class PedidoImpl implements Pedido {
    private Long id;
    private Long clienteId;
    private List<PedidoItem> pedidoItem;

    public PedidoImpl(Long id) {
        this.id = id;
    }

    public PedidoImpl(Long clienteId, List<PedidoItem> pedidoItem) {
        this.clienteId = clienteId;
        this.pedidoItem = pedidoItem;
    }

    public Long getId() {
        return id;
    }

    @Override
    public Long getClienteId() {
        return this.clienteId;
    }

    @Override
    public List<PedidoItem> getPedidoItem() {
        return this.pedidoItem;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
