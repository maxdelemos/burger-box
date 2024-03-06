package com.fiappostech.burgerbox.infraestructure.gateway;

import com.fiappostech.burgerbox.core.entity.ClienteDomain;
import com.fiappostech.burgerbox.core.entity.cliente.Cliente;
import com.fiappostech.burgerbox.core.entity.cliente.ClienteFactory;
import com.fiappostech.burgerbox.core.gateway.ClienteGateway;
import com.fiappostech.burgerbox.infraestructure.persistence.cliente.ClienteEntity;
import com.fiappostech.burgerbox.infraestructure.persistence.cliente.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClienteGatewayImpl implements ClienteGateway {

    private final ClienteRepository clienteRepository;
    private final ClienteFactory clienteFactory;

    @Override
    public ClienteDomain cadastrar(ClienteDomain clienteDomain) {
        ClienteEntity clienteEntity = ClienteEntityMapper.INSTANCE.toEntity(clienteDomain);
        ClienteEntity novaPessoa = clienteRepository.save(clienteEntity);
        return ClienteEntityMapper.INSTANCE.toDomain(novaPessoa);
    }

    @Override
    public ClienteDomain buscarPorCpf(String cpf) {
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

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<ClienteEntity> clienteEntity = clienteRepository.findById(id);
        return clienteEntity.map(entity -> clienteFactory.create(
                entity.getId(),
                entity.getNome(),
                entity.getCpf()
        )).orElse(null);
    }
}
