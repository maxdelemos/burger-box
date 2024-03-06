package com.fiappostech.burgerbox.infraestructure.persistence.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
    List<ProdutoEntity> findAllByNomeAndAtivo(String nome, Boolean ativo);

    Optional<ProdutoEntity> findByIdAndAtivo(Long id, Boolean ativo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE produto " +
            "SET ativo=false, " +
            "data_atualizacao=CURRENT_TIMESTAMP " +
            "WHERE id= :id", nativeQuery = true)
    void remover(@Param("id") Long id);

    @Query(value = "SELECT * FROM produto WHERE id in (:ids)", nativeQuery = true)
    List<ProdutoEntity> buscarPorIds(@Param("ids") List<Long> ids);
}
