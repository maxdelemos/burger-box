package com.fiappostech.burgerbox.core.entity.pedido;

public class PedidoItemImpl implements PedidoItem {
    private Long id;
    private Integer quantidade;

    public PedidoItemImpl(Long id, Integer quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public Integer getQuantidade() {
        return this.quantidade;
    }
}
