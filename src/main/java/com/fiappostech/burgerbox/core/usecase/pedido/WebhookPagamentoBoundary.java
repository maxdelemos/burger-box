package com.fiappostech.burgerbox.core.usecase.pedido;

import com.fiappostech.burgerbox.core.entity.pedido.MPPagamentoWebhook;

public interface WebhookPagamentoBoundary {
    void execute(MPPagamentoWebhook mpPagamentoWebhook);
}
