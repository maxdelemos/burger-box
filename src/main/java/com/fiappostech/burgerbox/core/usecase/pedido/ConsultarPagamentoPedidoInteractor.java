package com.fiappostech.burgerbox.core.usecase.pedido;

import com.fiappostech.burgerbox.core.entity.pedido.PedidoPagamento;
import com.fiappostech.burgerbox.core.gateway.PedidoPagamentoGateway;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.response.ConsultarPagamentoPresenter;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.response.ConsultarPagamentoResponseModel;

import java.util.Objects;

public class ConsultarPagamentoPedidoInteractor implements ConsultarPagamentoPedidoBoundary {
    private final PedidoPagamentoGateway pedidoPagamentoGateway;
    private final ConsultarPagamentoPresenter consultarPagamentoPresenter;

    public ConsultarPagamentoPedidoInteractor(
            PedidoPagamentoGateway pedidoPagamentoGateway,
            ConsultarPagamentoPresenter consultarPagamentoPresenter
    ) {
        this.pedidoPagamentoGateway = pedidoPagamentoGateway;
        this.consultarPagamentoPresenter = consultarPagamentoPresenter;
    }

    @Override
    public ConsultarPagamentoResponseModel execute(Long pedidoId) {
        PedidoPagamento pedidoPagamento = pedidoPagamentoGateway.consultarPagamento(pedidoId);

        if (Objects.isNull(pedidoPagamento)) {
            return consultarPagamentoPresenter.prepareFailView("Pedido não encontrado");
        }

        return consultarPagamentoPresenter.prepareSuccessView(
                new ConsultarPagamentoResponseModel
                        (
                                pedidoPagamento.getPedidoId(),
                                pedidoPagamento.getStatus()
                        )
        );
    }
}
