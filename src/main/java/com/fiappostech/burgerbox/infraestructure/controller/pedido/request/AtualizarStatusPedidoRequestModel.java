package com.fiappostech.burgerbox.infraestructure.controller.pedido.request;

public class AtualizarStatusPedidoRequestModel {
    private Long id;
    private String status;

    public AtualizarStatusPedidoRequestModel(Long id, String status) {
        this.id = id;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
