package com.fiappostech.burgerbox.core.usecase.pedido;

import com.fiappostech.burgerbox.core.entity.pedido.Pedido;
import com.fiappostech.burgerbox.core.gateway.PedidoGateway;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.response.ListaPedidoResponseModel;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.response.PedidoPresenter;

import java.util.List;

public class ListarPedidoInteractor implements ListarPedidoBoundary {
    private final PedidoGateway pedidoGateway;
    private final PedidoPresenter pedidoPresenter;

    public ListarPedidoInteractor(PedidoGateway pedidoGateway, PedidoPresenter pedidoPresenter) {
        this.pedidoGateway = pedidoGateway;
        this.pedidoPresenter = pedidoPresenter;
    }

    @Override
    public List<ListaPedidoResponseModel> execute() {
        List<Pedido> pedidos = pedidoGateway.listar();
        return pedidos.stream().map(pedido -> new ListaPedidoResponseModel(
                pedido.getId(),
                pedido.getStatus(),
                pedido.getDataAtualizacao().toString()
        )).toList();
    }
}
