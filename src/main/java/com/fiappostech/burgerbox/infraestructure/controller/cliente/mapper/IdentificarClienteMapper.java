package com.fiappostech.burgerbox.infraestructure.controller.cliente.mapper;

import com.fiappostech.burgerbox.core.entity.ClienteDomain;
import com.fiappostech.burgerbox.infraestructure.dto.cliente.ClienteCadastrarOutput;
import com.fiappostech.burgerbox.infraestructure.dto.cliente.IdentificarClienteInput;
import com.fiappostech.burgerbox.infraestructure.dto.cliente.IdentificarClienteOutput;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IdentificarClienteMapper {
    IdentificarClienteMapper INSTANCE = Mappers.getMapper(IdentificarClienteMapper.class);

    ClienteDomain toDomain(IdentificarClienteInput identificarClienteInput);
    IdentificarClienteOutput toOutput(ClienteDomain clienteDomain);
    IdentificarClienteInput toInput(ClienteDomain clienteDomain);
}
