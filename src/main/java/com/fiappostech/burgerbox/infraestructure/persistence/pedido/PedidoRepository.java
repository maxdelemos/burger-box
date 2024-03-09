package com.fiappostech.burgerbox.infraestructure.persistence.pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE pedido " +
            "SET status = :status, " +
            "data_atualizacao=CURRENT_TIMESTAMP " +
            "WHERE id = :id", nativeQuery = true)
    void atualizarStatus(@Param("id") Long id, @Param("status") String status);

    @Query(value = "SELECT " +
            "id, " +
            "status, " +
            "data_atualizacao as dataAtualizacao " +
            "FROM pedido " +
            "WHERE status <> 'FINALIZADO' " +
            "ORDER BY data_atualizacao DESC ", nativeQuery = true)
    List<ListaPedidoProjection> listar();

    @Query(value = "SELECT * FROM pedido WHERE id = :id ", nativeQuery = true)
    PedidoEntity buscarPorIdTeste(@Param("id") Long id);
}
