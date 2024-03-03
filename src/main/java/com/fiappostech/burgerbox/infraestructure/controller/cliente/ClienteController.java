package com.fiappostech.burgerbox.infraestructure.controller.cliente;

import com.fiappostech.burgerbox.core.entity.Cliente;
import com.fiappostech.burgerbox.core.usecase.cliente.cadastrar.CriarClienteUseCase;
import com.fiappostech.burgerbox.infraestructure.dtos.clientedto.ClienteDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cliente")
@AllArgsConstructor
public class ClienteController {

    private final CriarClienteUseCase createClienteUseCase;
    private final ClienteDtoMapper clienteDtoMapper;

    @PostMapping
    public ClienteDto criarCliente(@RequestBody ClienteDto clienteDto) {
       Cliente novoCliente = createClienteUseCase.execute(clienteDtoMapper.converterParaDomain(clienteDto));
       return clienteDtoMapper.converterParaDto(novoCliente);
    }

}
