package com.fiappostech.burgerbox.core.usecase.pedido;

import com.fiappostech.burgerbox.core.entity.pedido.Pedido;
import com.fiappostech.burgerbox.core.entity.pedido.PedidoFactory;
import com.fiappostech.burgerbox.core.gateway.PedidoGateway;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.request.AtualizarStatusPedidoRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.response.AtualizarPedidoPresenter;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.response.AtualizarPedidoResponseModel;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.response.PedidoPresenter;

import java.util.Objects;

public class AtualizarPedidoInteractor implements AtualizarPedidoBoundary {
    private final PedidoGateway pedidoGateway;
    private final PedidoFactory pedidoFactory;
    private final AtualizarPedidoPresenter atualizarPedidoPresenter;

    public AtualizarPedidoInteractor(PedidoGateway pedidoGateway, PedidoFactory pedidoFactory, AtualizarPedidoPresenter atualizarPedidoPresenter) {
        this.pedidoGateway = pedidoGateway;
        this.pedidoFactory = pedidoFactory;
        this.atualizarPedidoPresenter = atualizarPedidoPresenter;
    }

    @Override
    public AtualizarPedidoResponseModel execute(Long id, AtualizarStatusPedidoRequestModel atualizarStatusPedidoRequestModel) {
        if (!Objects.equals(id, atualizarStatusPedidoRequestModel.getId())) {
            return atualizarPedidoPresenter.prepareFailView("O id da request está diferente do id que está no corpo da request.");
        }

        Pedido pedidoEncontrado = pedidoGateway.buscarPorId(atualizarStatusPedidoRequestModel.getId());
        if (Objects.isNull(pedidoEncontrado)) {
            return atualizarPedidoPresenter.prepareFailView("Pedido não encontrado.");
        }

        if (Boolean.FALSE.equals(pedidoGateway.statusPedidoExiste(atualizarStatusPedidoRequestModel.getStatus()))) {
            return atualizarPedidoPresenter.prepareFailView("Status não encontrado.");
        }

        Pedido pedido = pedidoFactory.create(
                atualizarStatusPedidoRequestModel.getId(),
                atualizarStatusPedidoRequestModel.getStatus()
        );

        Pedido pedidoAtualizado = pedidoGateway.editar(pedido);

        AtualizarPedidoResponseModel atualizarPedidoResponseModel = new AtualizarPedidoResponseModel(
                pedidoAtualizado.getId(),
                pedidoAtualizado.getStatus(),
                pedidoAtualizado.getDataAtualizacao()
        );

        return atualizarPedidoPresenter.prepareSuccessView(atualizarPedidoResponseModel);
    }
}
