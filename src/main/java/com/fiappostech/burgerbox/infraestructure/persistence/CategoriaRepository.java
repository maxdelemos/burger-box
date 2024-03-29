package com.fiappostech.burgerbox.infraestructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {

    @Query(value = "SELECT * FROM categoria WHERE codigo in (:codigos)", nativeQuery = true)
    List<CategoriaEntity> buscarPorCodigos(@Param("codigos") List<String> codigos);
}
