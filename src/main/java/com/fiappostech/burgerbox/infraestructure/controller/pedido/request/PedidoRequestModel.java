package com.fiappostech.burgerbox.infraestructure.controller.pedido.request;

import java.util.List;

public class PedidoRequestModel {
    private Long clienteId;
    private List<PedidoProdutoRequestModel> produto;

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<PedidoProdutoRequestModel> getProduto() {
        return produto;
    }

    public void setProduto(List<PedidoProdutoRequestModel> produto) {
        this.produto = produto;
    }
}
