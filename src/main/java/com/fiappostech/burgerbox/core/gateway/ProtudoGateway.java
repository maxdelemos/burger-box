package com.fiappostech.burgerbox.core.gateway;

import com.fiappostech.burgerbox.core.entity.ProdutoDomain;

public interface ProtudoGateway {
    ProdutoDomain cadastrar(ProdutoDomain produtoDomain);
    ProdutoDomain editar(ProdutoDomain produtoDomain);
    ProdutoDomain remover(ProdutoDomain produtoDomain);
}
