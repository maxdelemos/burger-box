package com.fiappostech.burgerbox.core.gateways.clientegateway;

import com.fiappostech.burgerbox.core.entity.Cliente;

//interface que irá possibilitar a conexão do core com os elementos externos
public interface ClienteGateway {

    Cliente criarCliente(Cliente cliente);
}
