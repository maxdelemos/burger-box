package com.fiappostech.burgerbox.core.entity.pedido;

import java.time.LocalDateTime;
import java.util.List;

public interface Pedido {
    Long getId();

    Long getClienteId();

    List<PedidoItem> getPedidoItem();

    String getStatus();

    LocalDateTime getDataAtualizacao();
}
