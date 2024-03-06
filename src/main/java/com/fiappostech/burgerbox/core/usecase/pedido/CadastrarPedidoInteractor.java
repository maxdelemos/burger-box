package com.fiappostech.burgerbox.core.usecase.pedido;

import com.fiappostech.burgerbox.core.entity.cliente.Cliente;
import com.fiappostech.burgerbox.core.entity.produto.Produto;
import com.fiappostech.burgerbox.core.gateway.ClienteGateway;
import com.fiappostech.burgerbox.core.gateway.PedidoGateway;
import com.fiappostech.burgerbox.core.gateway.ProdutoGateway;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.request.PedidoRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.request.ProdutoRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.response.PedidoResponseModel;

import java.util.List;
import java.util.Objects;

public class CadastrarPedidoInteractor implements CadastrarPedidoBoundary {
    private final PedidoGateway pedidoGateway;
    private final ClienteGateway clienteGateway;
    private final ProdutoGateway produtoGateway;

    public CadastrarPedidoInteractor(PedidoGateway pedidoGateway, ClienteGateway clienteGateway, ProdutoGateway produtoGateway) {
        this.pedidoGateway = pedidoGateway;
        this.clienteGateway = clienteGateway;
        this.produtoGateway = produtoGateway;
    }

    @Override
    public PedidoResponseModel execute(PedidoRequestModel pedidoRequestModel) {
        if (Objects.isNull(pedidoRequestModel.getClienteId())) {
            // presenter
            return null;
        }

        Cliente cliente = clienteGateway.buscarPorId(pedidoRequestModel.getClienteId());
        if (Objects.isNull(cliente)) {
            // presenter
            return null;
        }

        // valida se todas os produtos existem
        List<Produto> produtosEncontrados = produtoGateway.buscarPorIdsAtivo(pedidoRequestModel
                .getProdutoRequestMode()
                .stream()
                .map(ProdutoRequestModel::getId)
                .toList()
        );

        return null;
    }
}
