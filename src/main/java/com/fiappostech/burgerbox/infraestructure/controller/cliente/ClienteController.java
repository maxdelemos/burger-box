package com.fiappostech.burgerbox.infraestructure.controller.cliente;

import com.fiappostech.burgerbox.infraestructure.controller.cliente.request.ClienteRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.cliente.request.IdentificarRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.cliente.response.ClienteResponseModel;
import com.fiappostech.burgerbox.infraestructure.controller.cliente.response.IdentificarClienteResponseModel;
import com.fiappostech.burgerbox.infraestructure.swagger.ConflictException;
import com.fiappostech.burgerbox.infraestructure.swagger.InternalServerErrorException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Clientes")
@RequestMapping("/api/clientes")
public interface ClienteController {

    @Operation(summary = "Cadastrar um cliente")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Cliente cadastrado com sucesso"), @ApiResponse(responseCode = "409", description = "Requisição inválida", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ConflictException.class))}), @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = InternalServerErrorException.class))})})
    @PostMapping
    ResponseEntity<ClienteResponseModel> cadastrar(@RequestBody ClienteRequestModel clienteRequestModel);

    @Operation(summary = "Identificar um cliente")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Cliente identificado com sucesso"), @ApiResponse(responseCode = "409", description = "Requisição inválida", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ConflictException.class))}), @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = InternalServerErrorException.class))})})
    @PostMapping("/identificar")
    ResponseEntity<IdentificarClienteResponseModel> identificar(@RequestBody IdentificarRequestModel identificarClienteRequestModel);
}
