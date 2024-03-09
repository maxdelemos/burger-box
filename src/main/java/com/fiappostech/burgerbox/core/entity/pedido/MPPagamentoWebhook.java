package com.fiappostech.burgerbox.core.entity.pedido;

public class MPPagamentoWebhook {
    private Long id;
    private String type;
    private String action;
    private MPPagamentoWebhookData data;

    public MPPagamentoWebhook(Long id, String payment, String action) {
        this.id = id;
        this.type = payment;
        this.action = action;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MPPagamentoWebhookData getData() {
        return data;
    }

    public void setData(MPPagamentoWebhookData data) {
        this.data = data;
    }
}
