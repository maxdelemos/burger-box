package com.fiappostech.burgerbox.core.gateway;

import com.fiappostech.burgerbox.core.entity.ClienteDomain;
import com.fiappostech.burgerbox.core.entity.cliente.Cliente;
import com.fiappostech.burgerbox.infraestructure.persistence.cliente.ClienteEntity;

import java.util.Optional;

public interface ClienteGateway {
    ClienteDomain cadastrar(ClienteDomain clienteDomain);

    ClienteDomain buscarPorCpf(String cpf);

    ClienteDomain salvar(ClienteDomain clienteDomain);

    Cliente buscarPorId(Long id);
}
