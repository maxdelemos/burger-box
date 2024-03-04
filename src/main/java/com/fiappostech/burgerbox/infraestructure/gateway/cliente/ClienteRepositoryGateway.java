package com.fiappostech.burgerbox.infraestructure.gateway.cliente;

import com.fiappostech.burgerbox.core.entity.ClienteDomain;
import com.fiappostech.burgerbox.core.gateway.ClienteGateway;
import com.fiappostech.burgerbox.infraestructure.persistence.cliente.ClienteEntity;
import com.fiappostech.burgerbox.infraestructure.persistence.cliente.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClienteRepositoryGateway implements ClienteGateway {

    private final ClienteRepository clienteRepository;

    @Override
    public ClienteDomain cadastrarCliente(ClienteDomain clienteDomain) {
        ClienteEntity clienteEntity = ClienteEntityMapper.INSTANCE.toEntity(clienteDomain);
        ClienteEntity novaPessoa = clienteRepository.save(clienteEntity);
        return ClienteEntityMapper.INSTANCE.toDomain(novaPessoa);
    }

    @Override
    public ClienteDomain buscar(String cpf) {
        ClienteEntity clienteEntity = clienteRepository.findAllByCpf(cpf);
        if (clienteEntity == null) {
            return null;
        }
        return ClienteEntityMapper.INSTANCE.toDomain(clienteEntity);
    }

    @Override
    public ClienteDomain salvar(ClienteDomain clienteDomain) {
        ClienteEntity clienteEntity = ClienteEntityMapper.INSTANCE.toEntity(clienteDomain);
        return ClienteEntityMapper.INSTANCE.toDomain(clienteRepository.saveAndFlush(clienteEntity));
    }
}
