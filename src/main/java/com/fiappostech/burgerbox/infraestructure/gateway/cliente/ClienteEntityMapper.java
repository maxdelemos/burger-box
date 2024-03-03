package com.fiappostech.burgerbox.infraestructure.gateway.cliente;

import com.fiappostech.burgerbox.core.entity.ClienteDomain;
import com.fiappostech.burgerbox.infraestructure.persistence.cliente.ClienteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClienteEntityMapper {

    ClienteEntityMapper INSTANCE = Mappers.getMapper(ClienteEntityMapper.class);

    ClienteEntity toEntity(ClienteDomain clienteDomain);

    ClienteDomain toDomain(ClienteEntity clienteEntity);
}
