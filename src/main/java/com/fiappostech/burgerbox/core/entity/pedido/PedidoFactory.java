package com.fiappostech.burgerbox.core.entity.pedido;

import com.fiappostech.burgerbox.core.entity.pagamento.Pagamento;

import java.time.LocalDateTime;
import java.util.List;

public interface PedidoFactory {
    Pedido create(Long id, String status);

    Pedido create(Long clienteId, List<PedidoItem> pedidoItem, Pagamento pagamento);

    Pedido create(Long id, String status, LocalDateTime dataAtualizacao);

    Pedido create(Long id, String status, List<PedidoItem> pedidoItems, LocalDateTime dataAtualizacao);

    Pedido create(Long id, Pagamento pagamento);
    Pedido create(Long id, String status, PedidoPagamento pedidoPagamento);
}
