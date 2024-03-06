package com.fiappostech.burgerbox.core.usecase.cliente;

import com.fiappostech.burgerbox.core.entity.ClienteDomain;
import com.fiappostech.burgerbox.core.exceptions.BusinessException;
import com.fiappostech.burgerbox.core.gateway.ClienteGateway;

public class CadastrarClienteUseCaseImpl implements CadastrarClienteUseCase {
    private final ClienteGateway clienteGateway;

    public CadastrarClienteUseCaseImpl(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    @Override
    public ClienteDomain execute(ClienteDomain cliente) {
       ClienteDomain clienteExistente =  clienteGateway.buscarPorCpf(cliente.cpf());
       if(clienteExistente != null) {
           throw new BusinessException("Já existe um cliente cadastrado com o CPF: " + cliente.cpf());
       }
        return clienteGateway.cadastrar(cliente);
    }
}
