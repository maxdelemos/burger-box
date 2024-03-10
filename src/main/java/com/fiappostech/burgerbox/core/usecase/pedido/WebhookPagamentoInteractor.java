package com.fiappostech.burgerbox.core.usecase.pedido;

import com.fiappostech.burgerbox.core.entity.pagamento.Pagamento;
import com.fiappostech.burgerbox.core.entity.pagamento.PagamentoWebhook;
import com.fiappostech.burgerbox.core.entity.pedido.PedidoFactory;
import com.fiappostech.burgerbox.core.entity.pedido.PedidoPagamento;
import com.fiappostech.burgerbox.core.entity.pedido.PedidoPagamentoFactory;
import com.fiappostech.burgerbox.core.gateway.MercadoPagoGateway;
import com.fiappostech.burgerbox.core.gateway.PedidoGateway;
import com.fiappostech.burgerbox.core.gateway.PedidoPagamentoGateway;

import java.util.Objects;

public class WebhookPagamentoInteractor implements WebhookPagamentoBoundary {
    private final MercadoPagoGateway mercadoPagoGateway;
    private final PedidoPagamentoGateway pedidoPagamentoGateway;
    private final PedidoGateway pedidoGateway;
    private final PedidoFactory pedidoFactory;
    private final PedidoPagamentoFactory pedidoPagamentoFactory;

    public WebhookPagamentoInteractor(
            MercadoPagoGateway mercadoPagoGateway,
            PedidoPagamentoGateway pedidoPagamentoGateway,
            PedidoFactory pedidoFactory,
            PedidoPagamentoFactory pedidoPagamentoFactory,
            PedidoGateway pedidoGateway
    ) {
        this.mercadoPagoGateway = mercadoPagoGateway;
        this.pedidoPagamentoGateway = pedidoPagamentoGateway;
        this.pedidoFactory = pedidoFactory;
        this.pedidoPagamentoFactory = pedidoPagamentoFactory;
        this.pedidoGateway = pedidoGateway;
    }

    @Override
    public void execute(PagamentoWebhook mpPagamentoWebhook) {
        switch (mpPagamentoWebhook.getAction()) {
            case "payment.updated":
                Pagamento pagamento = mercadoPagoGateway.consultarPagamento(mpPagamentoWebhook.getData().getId());
                PedidoPagamento pedidoPagamento = pedidoPagamentoGateway.buscarPorPagamentoId(pagamento.getId());
                if (Objects.nonNull(pedidoPagamento)) {
                    pedidoGateway.atualizarPagamento(pedidoPagamento.getPedidoId());
                    pedidoPagamentoGateway.atualizarPagamento(pedidoPagamento.getId());
                }
                break;
            default:
                break;
        }
    }
}
