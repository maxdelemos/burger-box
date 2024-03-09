package com.fiappostech.burgerbox.infraestructure.controller.pedido.response;

import java.time.LocalDateTime;

public class AtualizarPedidoResponseModel {
    private Long id;
    private String status;
    private LocalDateTime dataAtualizacao;

    public AtualizarPedidoResponseModel(Long id, String status, LocalDateTime dataAtualizacao) {
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

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
