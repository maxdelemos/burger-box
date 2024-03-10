package com.fiappostech.burgerbox.core.gateway;

import com.fiappostech.burgerbox.core.entity.pedido.Pedido;

import java.util.List;

public interface PedidoGateway {
    Pedido buscarPorId(Long id);
    Pedido cadastrar(Pedido pedido);
    Pedido editar(Pedido pedido);
    Boolean statusPedidoExiste(String status);
    List<Pedido> listar();
    void atualizarPagamento(Long id);
}
