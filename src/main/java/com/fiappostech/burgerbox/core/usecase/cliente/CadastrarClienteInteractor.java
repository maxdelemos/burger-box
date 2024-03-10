package com.fiappostech.burgerbox.core.usecase.cliente;

import com.fiappostech.burgerbox.core.entity.cliente.Cliente;
import com.fiappostech.burgerbox.core.entity.cliente.ClienteFactory;
import com.fiappostech.burgerbox.core.gateway.ClienteGateway;
import com.fiappostech.burgerbox.infraestructure.controller.cliente.response.ClientePresenter;
import com.fiappostech.burgerbox.infraestructure.controller.cliente.request.ClienteRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.cliente.response.ClienteResponseModel;

import java.util.Objects;

public class CadastrarClienteInteractor implements CadastrarClienteBoundary {
    private final ClienteGateway clienteGateway;
    private final ClienteFactory clienteFactory;
    private final ClientePresenter clientePedidoPresenter;

    public CadastrarClienteInteractor(
            ClienteGateway clienteGateway,
            ClienteFactory clienteFactory,
            ClientePresenter clientePedidoPresenter) {
        this.clienteGateway = clienteGateway;
        this.clienteFactory = clienteFactory;
        this.clientePedidoPresenter = clientePedidoPresenter;
    }

    @Override
    public ClienteResponseModel execute(ClienteRequestModel clienteRequestModel) {
        Cliente cliente = clienteGateway.buscarPorEmail(clienteRequestModel.getEmail());
        if (Objects.nonNull(cliente)) {
            return clientePedidoPresenter.prepareFailView("Existe um cliente cadastrado com o mesmo email.");
        }

        Cliente novoCliente = clienteFactory.create(
                clienteRequestModel.getNome(),
                clienteRequestModel.getEmail()
        );
        Cliente clienteCadastrado = clienteGateway.cadastrar(novoCliente);

        return clientePedidoPresenter.prepareSuccessView(
                new ClienteResponseModel(
                        clienteCadastrado.getId(),
                        clienteCadastrado.getNome(),
                        clienteCadastrado.getEmail(),
                        clienteCadastrado.getDataCriacao(),
                        clienteCadastrado.getDataAtualizacao()
                ));
    }
}
