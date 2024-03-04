package com.fiappostech.burgerbox.infraestructure.controller.cliente;

import com.fiappostech.burgerbox.core.entity.ClienteDomain;
import com.fiappostech.burgerbox.core.usecase.cliente.CadastrarClienteUseCase;
import com.fiappostech.burgerbox.core.usecase.cliente.IdentificarClienteUseCase;
import com.fiappostech.burgerbox.infraestructure.controller.cliente.mapper.CadastrarClienteMapper;
import com.fiappostech.burgerbox.infraestructure.controller.cliente.mapper.IdentificarClienteMapper;
import com.fiappostech.burgerbox.infraestructure.dto.cliente.ClienteCadastrarInput;
import com.fiappostech.burgerbox.infraestructure.dto.cliente.ClienteCadastrarOutput;
import com.fiappostech.burgerbox.infraestructure.dto.cliente.IdentificarClienteInput;
import com.fiappostech.burgerbox.infraestructure.dto.cliente.IdentificarClienteOutput;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cliente")
@AllArgsConstructor
public class ClienteController {

    private final CadastrarClienteUseCase createClienteUseCase;
    private final IdentificarClienteUseCase identificarClienteUseCase;

    @PostMapping("/cadastrar")
    public ClienteCadastrarOutput cadastrar(@RequestBody @Valid ClienteCadastrarInput clienteInput) {
        ClienteDomain clienteDomain = CadastrarClienteMapper.INSTANCE.toDomain(clienteInput);
        ClienteDomain novoClienteDomain = createClienteUseCase.execute(clienteDomain);
        ClienteCadastrarOutput clienteOutput = CadastrarClienteMapper.INSTANCE.toOutput(novoClienteDomain);
        return clienteOutput;
    }

    @PostMapping("/identificar")
    public ResponseEntity<IdentificarClienteOutput> identificar(@RequestBody IdentificarClienteInput identificarClienteInput) {
        ClienteDomain clienteDomain = IdentificarClienteMapper.INSTANCE.toDomain(identificarClienteInput);
        ClienteDomain clienteIdentificado = identificarClienteUseCase.execute(clienteDomain);
        IdentificarClienteOutput identificarClienteOutput = IdentificarClienteMapper.INSTANCE.toOutput(clienteIdentificado);
        return ResponseEntity.ok(identificarClienteOutput);
    }
}
