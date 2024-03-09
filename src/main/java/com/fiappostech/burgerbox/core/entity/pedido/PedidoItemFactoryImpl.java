package com.fiappostech.burgerbox.core.entity.pedido;

public class PedidoItemFactoryImpl implements PedidoItemFactory {
    @Override
    public PedidoItem create(Long id, Integer quantidade) {
        return new PedidoItemImpl(id, quantidade);
    }

    @Override
    public PedidoItem create(Long id, Integer quantidade, Double preco) {
        return new PedidoItemImpl(id, quantidade, preco);
    }
}
