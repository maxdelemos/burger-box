package com.fiappostech.burgerbox.infraestructure.gateways.cliente;

import com.fiappostech.burgerbox.core.entity.ClienteDomain;
import com.fiappostech.burgerbox.core.gateway.cliente.ClienteGateway;
import com.fiappostech.burgerbox.infraestructure.persistence.cliente.ClienteEntity;
import com.fiappostech.burgerbox.infraestructure.persistence.cliente.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClienteRepositoryGateway implements ClienteGateway {

    private final ClienteRepository clienteRepository;
    private final ClienteEntityMapper clienteEntityMapper;

    @Override
    public ClienteDomain cadastrarCliente(ClienteDomain clienteDomain) {
        ClienteEntity clienteEntity = clienteEntityMapper.toEntity(clienteDomain);
        ClienteEntity novaPessoa = clienteRepository.save(clienteEntity);
        return clienteEntityMapper.toDomain(novaPessoa);
    }
}
