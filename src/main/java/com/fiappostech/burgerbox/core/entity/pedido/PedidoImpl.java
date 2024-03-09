package com.fiappostech.burgerbox.core.entity.pedido;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoImpl implements Pedido {
    private Long id;
    private Long clienteId;
    private List<PedidoItem> pedidoItem;
    private String status;
    private LocalDateTime dataAtualizacao;

    public PedidoImpl(Long id, String status, List<PedidoItem> pedidoItem, LocalDateTime dataAtualizacao) {
        this.id = id;
        this.status = status;
        this.dataAtualizacao = dataAtualizacao;
        this.pedidoItem = pedidoItem;
    }

    public PedidoImpl(Long id, String status, LocalDateTime dataAtualizacao) {
        this.id = id;
        this.status = status;
        this.dataAtualizacao = dataAtualizacao;
    }

    public PedidoImpl(Long clienteId, List<PedidoItem> pedidoItem) {
        this.clienteId = clienteId;
        this.pedidoItem = pedidoItem;
    }

    public PedidoImpl(Long id, String status) {
        this.id = id;
        this.status = status;
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

    @Override
    public String getStatus() {
        return this.status;
    }

    @Override
    public LocalDateTime getDataAtualizacao() {
        return this.dataAtualizacao;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
