package com.fiappostech.burgerbox.infraestructure.persistence.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
    List<ProdutoEntity> findAllByNome(String nome);
}
