package com.fiappostech.burgerbox.infraestructure.controller.cliente;

import com.fiappostech.burgerbox.core.entity.Cliente;
import com.fiappostech.burgerbox.infraestructure.dtos.clientedto.ClienteDto;
import org.springframework.stereotype.Component;

@Component
public class ClienteDtoMapper {

    // Dessa forma existe uma dependencia porém está sendo de fora para dentro.
    public ClienteDto converterParaDto(Cliente cliente) {
        return new ClienteDto(cliente.nome(), cliente.cpf(), cliente.dataCriacao(), cliente.dataAtualizacao());
    }
    public Cliente converterParaDomain (ClienteDto clienteDto) {
        return new Cliente(null, clienteDto.nome(), clienteDto.cpf(), clienteDto.dataCriacao(), clienteDto.dataAtualizacao());
    }
}
