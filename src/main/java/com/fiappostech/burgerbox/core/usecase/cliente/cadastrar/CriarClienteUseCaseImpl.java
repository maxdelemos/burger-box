package com.fiappostech.burgerbox.core.usecase.cliente.cadastrar;

import com.fiappostech.burgerbox.core.entity.Cliente;
import com.fiappostech.burgerbox.core.gateways.clientegateway.ClienteGateway;

public class CriarClienteUseCaseImpl implements CriarClienteUseCase {

    private final ClienteGateway clienteGateway;

    public CriarClienteUseCaseImpl(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    @Override
    public Cliente execute(Cliente cliente) {

        return clienteGateway.criarCliente(cliente);
    }

}
