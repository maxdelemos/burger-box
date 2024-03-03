package com.fiappostech.burgerbox.core.gateway.cliente;

import com.fiappostech.burgerbox.core.entity.ClienteDomain;

public interface ClienteGateway {
    ClienteDomain cadastrarCliente(ClienteDomain clienteDomain);
}
