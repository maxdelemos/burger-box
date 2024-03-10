package com.fiappostech.burgerbox.core.usecase.cliente;

import com.fiappostech.burgerbox.core.entity.cliente.Cliente;
import com.fiappostech.burgerbox.core.entity.cliente.ClienteFactory;
import com.fiappostech.burgerbox.core.gateway.ClienteGateway;
import com.fiappostech.burgerbox.infraestructure.controller.cliente.request.IdentificarRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.cliente.response.IdentificarClientePresenter;
import com.fiappostech.burgerbox.infraestructure.controller.cliente.response.IdentificarClienteResponseModel;

import java.util.Objects;

public class IdentificarClienteInteractor implements IdentificarClienteBoundary {
    private final ClienteGateway clienteGateway;
    private final ClienteFactory clienteFactory;
    private final IdentificarClientePresenter identificarClientePresenter;

    public IdentificarClienteInteractor(
            ClienteGateway clienteGateway,
            ClienteFactory clienteFactory,
            IdentificarClientePresenter identificarClientePresenter
    ) {
        this.clienteGateway = clienteGateway;
        this.clienteFactory = clienteFactory;
        this.identificarClientePresenter = identificarClientePresenter;
    }

    @Override
    public IdentificarClienteResponseModel execute(IdentificarRequestModel identificarRequestModel) {
        Cliente clienteEncontrado = clienteGateway.buscarPorEmail(identificarRequestModel.getCpf());
        if (!Objects.isNull(clienteEncontrado)) {
            return new IdentificarClienteResponseModel(
                    clienteEncontrado.getId(),
                    clienteEncontrado.getNome(),
                    clienteEncontrado.getCpf(),
                    clienteEncontrado.getEmail()
            );
        }

        Cliente cliente = clienteFactory.create(
                identificarRequestModel.getCpf()
        );
        Cliente clienteidentificado = clienteGateway.identificar(cliente);

        return identificarClientePresenter.prepareSuccessView(
                new IdentificarClienteResponseModel(
                        clienteidentificado.getId(),
                        clienteidentificado.getNome(),
                        clienteidentificado.getCpf(),
                        clienteidentificado.getEmail()
                )
        );
    }
}
