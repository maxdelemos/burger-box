package com.fiappostech.burgerbox.infraestructure.gateway;

import com.fiappostech.burgerbox.core.gateway.PedidoGateway;
import com.fiappostech.burgerbox.infraestructure.persistence.pedido.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PedidoGatewayImpl implements PedidoGateway {
    private final PedidoRepository pedidoRepository;
}
