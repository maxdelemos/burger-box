package com.fiappostech.burgerbox.core.entity.pedido;

public class PedidoPagamentoImpl implements PedidoPagamento {
    private Long id;

    private Long pedidoId;

    private Long pagamentoId;

    private String status;

    public PedidoPagamentoImpl(Long id, Long pedidoId, Long pagamentoId, String status) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.pagamentoId = pagamentoId;
        this.status = status;
    }

    public PedidoPagamentoImpl(Long id, String status) {
        this.id = id;
        this.status = status;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public Long getPedidoId() {
        return this.pedidoId;
    }

    @Override
    public Long getPagamentoId() {
        return this.pagamentoId;
    }

    @Override
    public String getStatus() {
        return this.status;
    }
}
