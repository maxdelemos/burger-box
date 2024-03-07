package com.fiappostech.burgerbox.core.entity.pedido;

import java.util.List;

public interface Pedido {
    Long getId();

    Long getClienteId();

    List<PedidoItem> getPedidoItem();
}
