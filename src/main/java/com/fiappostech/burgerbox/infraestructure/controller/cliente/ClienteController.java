package com.fiappostech.burgerbox.infraestructure.controller.cliente;

import com.fiappostech.burgerbox.core.entity.ClienteDomain;
import com.fiappostech.burgerbox.core.usecase.cliente.CadastrarClienteUseCase;
import com.fiappostech.burgerbox.infraestructure.dto.cliente.ClienteCadastrarInput;
import com.fiappostech.burgerbox.infraestructure.dto.cliente.ClienteCadastrarOutput;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cliente")
@AllArgsConstructor
public class ClienteController {

    private final CadastrarClienteUseCase createClienteUseCase;
    private final ClienteMapper clienteDtoMapper;

    @PostMapping
    public ClienteCadastrarOutput cadastrar(@RequestBody ClienteCadastrarInput clienteInput) {
        ClienteDomain clienteDomain = clienteDtoMapper.toDomain(clienteInput);
        ClienteDomain novoClienteDomain = createClienteUseCase.execute(clienteDomain);
        ClienteCadastrarOutput clienteOutput = clienteDtoMapper.toOutput(novoClienteDomain);
        return clienteOutput;
    }
}
