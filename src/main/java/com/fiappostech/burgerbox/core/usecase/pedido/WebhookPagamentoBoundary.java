package com.fiappostech.burgerbox.core.usecase.pedido;

import com.fiappostech.burgerbox.core.entity.pagamento.PagamentoWebhook;

public interface WebhookPagamentoBoundary {
    void execute(PagamentoWebhook mpPagamentoWebhook);
}
