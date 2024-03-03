package com.fiappostech.burgerbox.infraestructure.controller.cliente;

import com.fiappostech.burgerbox.core.entity.ClienteDomain;
import com.fiappostech.burgerbox.infraestructure.dto.cliente.ClienteCadastrarInput;
import com.fiappostech.burgerbox.infraestructure.dto.cliente.ClienteCadastrarOutput;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ClienteMapper {

    public ClienteCadastrarOutput toOutput(ClienteDomain clienteDomain) {
        return new ClienteCadastrarOutput(clienteDomain.nome(), clienteDomain.cpf(), clienteDomain.dataCriacao(), clienteDomain.dataAtualizacao());
    }

    public ClienteDomain toDomain(ClienteCadastrarInput clienteInput) {
        return new ClienteDomain(null, clienteInput.nome(), clienteInput.cpf(), LocalDateTime.now(), LocalDateTime.now());
    }
}
