package com.fiappostech.burgerbox.core.gateway;

import com.fiappostech.burgerbox.core.entity.produto.Categoria;

import java.util.List;

public interface CategoriaGateway {
    List<Categoria> buscarPorCodigos(List<String> codigos);
}
