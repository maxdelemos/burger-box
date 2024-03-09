package com.fiappostech.burgerbox.infraestructure.controller.pedido.response;

public class ListaPedidoResponseModel {
    private Long id;
    private String status;
    private String dataAtualizacao;

    public ListaPedidoResponseModel(Long id, String status, String dataAtualizacao) {
        this.id = id;
        this.status = status;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(String dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
