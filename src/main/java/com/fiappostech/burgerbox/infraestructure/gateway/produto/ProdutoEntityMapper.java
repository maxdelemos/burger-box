package com.fiappostech.burgerbox.infraestructure.gateway.produto;

import com.fiappostech.burgerbox.core.entity.produto.factory.Produto;
import com.fiappostech.burgerbox.infraestructure.persistence.produto.ProdutoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProdutoEntityMapper {
    ProdutoEntityMapper INSTANCE = Mappers.getMapper(ProdutoEntityMapper.class);
    ProdutoEntity toEntity(Produto produto);
}
