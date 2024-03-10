package com.fiappostech.burgerbox.core.entity.pedido;

import com.fiappostech.burgerbox.core.entity.pagamento.Pagamento;

import java.time.LocalDateTime;
import java.util.List;

public interface Pedido {
    Long getId();

    Long getClienteId();

    Pagamento getPagamento();

    List<PedidoItem> getPedidoItem();

    String getStatus();

    LocalDateTime getDataAtualizacao();

    PedidoPagamento getPedidoPagamento();
}
