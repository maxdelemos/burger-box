package com.fiappostech.burgerbox.core.entity.produto.factory;

import com.fiappostech.burgerbox.core.entity.produto.CategoriaFactory;

public class CategoriaCommonFactory implements CategoriaFactory {
    @Override
    public CategoriaCommon create(long id, String descricao, String codigo) {
        return new CategoriaCommon(id, descricao, codigo);
    }
}
