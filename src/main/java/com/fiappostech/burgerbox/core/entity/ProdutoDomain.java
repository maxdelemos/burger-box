package com.fiappostech.burgerbox.core.entity;

import com.fiappostech.burgerbox.infraestructure.persistence.categoria.CategoriaEntity;
import jakarta.persistence.*;

import java.util.List;

public record ProdutoDomain(
        long id,

        String nome,

        List<CategoriaDomain> categorias,

        double preco
) {
}
