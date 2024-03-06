package com.fiappostech.burgerbox.core.entity.produto;

public class CategoriaFactoryImpl implements CategoriaFactory {
    @Override
    public CategoriaImpl create(long id, String descricao, String codigo) {
        return new CategoriaImpl(id, descricao, codigo);
    }
}
