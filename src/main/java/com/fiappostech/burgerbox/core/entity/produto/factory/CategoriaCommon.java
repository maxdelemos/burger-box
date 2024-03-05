package com.fiappostech.burgerbox.core.entity.produto.factory;

import com.fiappostech.burgerbox.core.entity.produto.Categoria;

public class CategoriaCommon implements Categoria {
    long id;
    String descricao;
    String codigo;

    public CategoriaCommon(long id, String descricao, String codigo) {
        this.id = id;
        this.descricao = descricao;
        this.codigo = codigo;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public String getCodigo() {
        return this.codigo;
    }
}

