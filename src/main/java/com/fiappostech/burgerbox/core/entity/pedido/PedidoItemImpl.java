package com.fiappostech.burgerbox.core.entity.pedido;

public class PedidoItemImpl implements PedidoItem {
    private Long id;
    private Integer quantidade;
    private Double preco;

    public PedidoItemImpl(Long id, Integer quantidade, Double preco) {
        this.id = id;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public PedidoItemImpl(Long id, Integer quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    @Override
    public Long geProdutoId() {
        return this.id;
    }

    @Override
    public Integer getQuantidade() {
        return this.quantidade;
    }

    @Override
    public Double getPreco() {
        return this.preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
