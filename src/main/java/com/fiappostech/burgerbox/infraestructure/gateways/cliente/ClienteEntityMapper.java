package com.fiappostech.burgerbox.infraestructure.gateways.cliente;

import com.fiappostech.burgerbox.core.entity.ClienteDomain;
import com.fiappostech.burgerbox.infraestructure.persistence.cliente.ClienteEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ClienteEntityMapper {

    public ClienteEntity toEntity(ClienteDomain cliente) {
        return new ClienteEntity(cliente.id(), cliente.nome(), cliente.cpf(), cliente.dataCriacao(), cliente.dataAtualizacao());
    }

    public ClienteDomain toDomain(ClienteEntity entity) {
        return new ClienteDomain(entity.getId(), entity.getNome(), entity.getCpf(), entity.getDataCriacao(), entity.getDataAtualizacao());
    }
}
