package com.fiappostech.burgerbox.core.entity.produto;

public class CategoriaImpl implements Categoria {
    Long id;
    String descricao;
    String codigo;

    public CategoriaImpl(Long id, String descricao, String codigo) {
        this.id = id;
        this.descricao = descricao;
        this.codigo = codigo;
    }

    @Override
    public Long getId() {
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

