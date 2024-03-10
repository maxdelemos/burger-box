package com.fiappostech.burgerbox.infraestructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoPamentoRepository extends JpaRepository<PedidoPagamentoEntity, Long> {

    @Query(value = "SELECT * FROM pedido_pagamento WHERE pagamento_id = :pagamentoId ", nativeQuery = true)
    PedidoPagamentoEntity buscarPorPagamentoId(@Param("pagamentoId") Long pagamentoId);

    @Query(value = "SELECT * FROM pedido_pagamento WHERE pedido_id = :pedidoId ", nativeQuery = true)
    PedidoPagamentoEntity buscarPorPedidoId(@Param("pedidoId") Long pedidoId);
}
