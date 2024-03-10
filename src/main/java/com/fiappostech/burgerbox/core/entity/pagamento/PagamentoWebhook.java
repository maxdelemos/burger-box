package com.fiappostech.burgerbox.core.entity.pagamento;

public class PagamentoWebhook {
    private Long id;
    private String type;
    private String action;
    private PagamentoWebhookData data;

    public PagamentoWebhook(Long id, String payment, String action) {
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

    public PagamentoWebhookData getData() {
        return data;
    }

    public void setData(PagamentoWebhookData data) {
        this.data = data;
    }
}
