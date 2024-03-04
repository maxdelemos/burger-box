package com.fiappostech.burgerbox.infraestructure.gateway.produto;

import com.fiappostech.burgerbox.core.entity.ClienteDomain;
import com.fiappostech.burgerbox.core.entity.ProdutoDomain;
import com.fiappostech.burgerbox.infraestructure.gateway.cliente.ClienteEntityMapper;
import com.fiappostech.burgerbox.infraestructure.persistence.cliente.ClienteEntity;
import com.fiappostech.burgerbox.infraestructure.persistence.produto.ProdutoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProdutoEntityMapper {
    ProdutoEntityMapper INSTANCE = Mappers.getMapper(ProdutoEntityMapper.class);

    ProdutoEntity toEntity(ProdutoDomain produtoDomain);

    ProdutoDomain toDomain(ProdutoEntity produtoEntity);
}
