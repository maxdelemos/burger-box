package com.fiappostech.burgerbox.core.usecase.pedido;

import com.fiappostech.burgerbox.core.entity.pedido.MPPagamentoWebhook;
import com.fiappostech.burgerbox.core.gateway.MercadoPagoGateway;

public class WebhookPagamentoInteractor implements WebhookPagamentoBoundary {
    private final MercadoPagoGateway mercadoPagoGateway;

    public WebhookPagamentoInteractor(MercadoPagoGateway mercadoPagoGateway) {
        this.mercadoPagoGateway = mercadoPagoGateway;
    }

    @Override
    public void execute(MPPagamentoWebhook mpPagamentoWebhook) {
        switch (mpPagamentoWebhook.getAction()) {
            case "payment.updated":
                mercadoPagoGateway.consultarPagamento(mpPagamentoWebhook.getData().getId());
                break;
            default:
                break;
        }
    }
}
