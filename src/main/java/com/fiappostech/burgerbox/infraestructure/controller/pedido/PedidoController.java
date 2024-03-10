package com.fiappostech.burgerbox.infraestructure.controller.pedido;

import com.fiappostech.burgerbox.core.entity.pagamento.PagamentoWebhook;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.request.AtualizarStatusPedidoRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.request.PedidoRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.response.ListaPedidoResponseModel;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.response.PedidoResponseModel;
import com.fiappostech.burgerbox.infraestructure.swagger.ConflictException;
import com.fiappostech.burgerbox.infraestructure.swagger.InternalServerErrorException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Pedidos")
@RequestMapping("/api/pedidos")
public interface PedidoController {

    @Operation(summary = "Cadastrar um pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido cadastrado com sucesso"),
            @ApiResponse(responseCode = "409", description = "Requisição inválida",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConflictException.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = InternalServerErrorException.class))})
    })
    @PostMapping
    ResponseEntity<PedidoResponseModel> cadastrar(@RequestBody PedidoRequestModel pedidoRequestModel);

    @Operation(summary = "Listar os pedidos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido lista com sucesso"),
            @ApiResponse(responseCode = "409", description = "Requisição inválida",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConflictException.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = InternalServerErrorException.class))})
    })
    @GetMapping
    ResponseEntity<List<ListaPedidoResponseModel>> listar();

    @Operation(summary = "Consultar status do pagamento do pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consultado status do pagamento do pedido com sucesso"),
            @ApiResponse(responseCode = "409", description = "Requisição inválida",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConflictException.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = InternalServerErrorException.class))})
    })
    @GetMapping("/{id}/status-pagamento")
    ResponseEntity<Object> statusPagamento(@PathVariable Long id);

    @Operation(summary = "Webhook para receber atualização de pagamento do pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualização recebida com sucesso"),
            @ApiResponse(responseCode = "409", description = "Requisição inválida",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConflictException.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = InternalServerErrorException.class))})
    })
    @PostMapping("/webhooks/pagamento")
    void webhooksPagamento(@RequestBody PagamentoWebhook mpPagamentoWebhook);

    @Operation(summary = "Consultar status do pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consultado status do pedido com sucesso"),
            @ApiResponse(responseCode = "409", description = "Requisição inválida",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConflictException.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = InternalServerErrorException.class))})
    })
    @PutMapping("/{id}/status")
    ResponseEntity<Object> status(@PathVariable Long id, @RequestBody AtualizarStatusPedidoRequestModel atualizarStatusPedidoRequestModel);
}
