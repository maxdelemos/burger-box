package com.fiappostech.burgerbox.infraestructure.persistence.pedido;

import java.time.LocalDateTime;

public interface ListaPedidoProjection {
    Long getId();
    String getStatus();
    LocalDateTime getDataAtualizacao();
}
