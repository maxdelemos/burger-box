package com.fiappostech.burgerbox.core.usecase.cliente;

import com.fiappostech.burgerbox.core.entity.ClienteDomain;
import com.fiappostech.burgerbox.core.gateway.ClienteGateway;

import java.util.Objects;

public class IdentificarClienteUseCaseImpl implements IdentificarClienteUseCase{
    private final ClienteGateway clienteGateway;

    public IdentificarClienteUseCaseImpl(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    @Override
    public ClienteDomain execute(ClienteDomain clienteDomain) {
        ClienteDomain cliente = clienteGateway.buscar(clienteDomain.cpf());
        if (!Objects.isNull(cliente)) {
            return cliente;
        }
        return clienteGateway.salvar(clienteDomain);
    }
}
