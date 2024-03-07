package com.fiappostech.burgerbox.core.gateway;

import com.fiappostech.burgerbox.core.entity.pedido.Pedido;

public interface PedidoGateway {
    Pedido cadastrar(Pedido pedido);
}
