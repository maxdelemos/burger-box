package com.fiappostech.burgerbox.infraestructure.gateways.cliente;

import com.fiappostech.burgerbox.core.entity.Cliente;
import com.fiappostech.burgerbox.infraestructure.persistence.Cliente.ClienteEntity;
import org.springframework.stereotype.Component;

@Component
public class ClienteEntityMapper {

    public ClienteEntity converterParaEntity(Cliente cliente) {
        return new ClienteEntity(cliente.id(), cliente.nome(), cliente.cpf(), cliente.dataCriacao(), cliente.dataAtualizacao());
    }

    public Cliente converterParaCliente(ClienteEntity entity) {
        return new Cliente(entity.getId(), entity.getNome(), entity.getCpf(), entity.getDataCriacao(), entity.getDataAtualizacao());
    }
}
