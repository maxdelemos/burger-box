package com.fiappostech.burgerbox.infraestructure.controller.pedido.request;

import java.util.List;

public class PedidoRequestModel {
    private Long clienteId;
    private List<ProdutoRequestModel> produtoRequestMode;

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<ProdutoRequestModel> getProdutoRequestMode() {
        return produtoRequestMode;
    }

    public void setProdutoRequestMode(List<ProdutoRequestModel> produtoRequestMode) {
        this.produtoRequestMode = produtoRequestMode;
    }
}
