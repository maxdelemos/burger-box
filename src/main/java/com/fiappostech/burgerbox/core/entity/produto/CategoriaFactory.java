package com.fiappostech.burgerbox.core.entity.produto;

public interface CategoriaFactory {
    Categoria create(long id, String descricao, String codigo);
}
