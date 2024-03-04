package com.fiappostech.burgerbox.core.usecase.cliente;

import com.fiappostech.burgerbox.core.entity.ClienteDomain;
import com.fiappostech.burgerbox.core.gateway.ClienteGateway;

public class CadastrarClienteUseCaseImpl implements CadastrarClienteUseCase {
    private final ClienteGateway clienteGateway;

    public CadastrarClienteUseCaseImpl(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    @Override
    public ClienteDomain execute(ClienteDomain cliente) {
        return clienteGateway.cadastrarCliente(cliente);
    }
}
