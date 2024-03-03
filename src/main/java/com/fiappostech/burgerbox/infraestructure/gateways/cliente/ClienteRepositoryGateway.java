package com.fiappostech.burgerbox.infraestructure.gateways.cliente;

import com.fiappostech.burgerbox.core.entity.Cliente;
import com.fiappostech.burgerbox.core.gateways.clientegateway.ClienteGateway;
import com.fiappostech.burgerbox.infraestructure.persistence.Cliente.ClienteEntity;
import com.fiappostech.burgerbox.infraestructure.persistence.Cliente.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClienteRepositoryGateway implements ClienteGateway {

    private final ClienteRepository clienteRepository;
    private final ClienteEntityMapper clienteEntityMapper;

    @Override
    public Cliente criarCliente(Cliente cliente) {
        ClienteEntity clienteEntity = clienteEntityMapper.converterParaEntity(cliente);
        ClienteEntity novaPessoa = clienteRepository.save(clienteEntity);
        return clienteEntityMapper.converterParaCliente(novaPessoa);
    }
}
