package com.fiappostech.burgerbox.core.entity.pedido;

import com.fiappostech.burgerbox.core.entity.pagamento.Pagamento;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoImpl implements Pedido {
    private Long id;
    private Long clienteId;
    private List<PedidoItem> pedidoItem;
    private String status;
    private LocalDateTime dataAtualizacao;
    private Pagamento pagamento;
    private PedidoPagamento pedidoPagamento;

    public PedidoImpl(Long id, String status, List<PedidoItem> pedidoItem, LocalDateTime dataAtualizacao) {
        this.id = id;
        this.status = status;
        this.dataAtualizacao = dataAtualizacao;
        this.pedidoItem = pedidoItem;
    }

    public PedidoImpl(Long id, String status, PedidoPagamento pedidoPagamento) {
        this.id = id;
        this.status = status;
        this.pedidoPagamento = pedidoPagamento;
    }

    public PedidoImpl(Long id, String status, LocalDateTime dataAtualizacao) {
        this.id = id;
        this.status = status;
        this.dataAtualizacao = dataAtualizacao;
    }

    public PedidoImpl(Long clienteId, List<PedidoItem> pedidoItem, Pagamento pagamento) {
        this.clienteId = clienteId;
        this.pedidoItem = pedidoItem;
        this.pagamento = pagamento;
    }

    public PedidoImpl(Long id, String status) {
        this.id = id;
        this.status = status;
    }

    public PedidoImpl(Long id, Pagamento pagamento) {
        this.id = id;
        this.pagamento = pagamento;
    }


    public Long getId() {
        return id;
    }

    @Override
    public Long getClienteId() {
        return this.clienteId;
    }

    @Override
    public Pagamento getPagamento() {
        return this.pagamento;
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

    @Override
    public PedidoPagamento getPedidoPagamento() {
        return this.pedidoPagamento;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
