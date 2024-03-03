package com.fiappostech.burgerbox.infraestructure.controller.cliente.mapper;

import com.fiappostech.burgerbox.core.entity.ClienteDomain;
import com.fiappostech.burgerbox.infraestructure.dto.cliente.ClienteCadastrarInput;
import com.fiappostech.burgerbox.infraestructure.dto.cliente.ClienteCadastrarOutput;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CadastrarClienteMapper {
    CadastrarClienteMapper INSTANCE = Mappers.getMapper(CadastrarClienteMapper.class);

    ClienteCadastrarOutput toOutput(ClienteDomain clienteDomain);
    ClienteDomain toDomain(ClienteCadastrarInput clienteCadastrarInput);
}
