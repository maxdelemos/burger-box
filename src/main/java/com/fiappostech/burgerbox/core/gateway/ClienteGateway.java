package com.fiappostech.burgerbox.core.gateway;

import com.fiappostech.burgerbox.core.entity.cliente.Cliente;

public interface ClienteGateway {
    Cliente cadastrar(Cliente cliente);

    Cliente buscarPorEmail(String email);

    Cliente buscarPorCpf(String cpf);

    Cliente identificar(Cliente cliente);

    Cliente buscarPorId(Long id);
}
