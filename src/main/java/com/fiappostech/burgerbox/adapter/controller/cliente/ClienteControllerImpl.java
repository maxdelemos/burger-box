package com.fiappostech.burgerbox.adapter.controller.cliente;

import com.fiappostech.burgerbox.domain.usecase.cliente.cadastrar.CadastrarClienteInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Clientes", description = "Api de clientes")
public class ClienteControllerImpl implements ClienteController {

    @Operation(
            summary = "Cadastrar cliente",
            description = "Este endpoint permite cadastrar uma nova cliente no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente cadastrada com sucesso")
    })
    @Override
    public ResponseEntity<Object> cadastrar(CadastrarClienteInput clienteInput) {
        return null;
    }
}
