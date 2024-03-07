package com.fiappostech.burgerbox.infraestructure.controller.pedido.response;

public class PedidoResponseModel {
    private Long id;
    public PedidoResponseModel(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
