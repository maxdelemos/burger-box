package com.fiappostech.burgerbox.infraestructure.controller.produto;

import com.fiappostech.burgerbox.infraestructure.controller.produto.request.ProdutoCadastrarRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.produto.request.ProdutoRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.produto.response.ProdutoResponseModel;
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

@Tag(name = "Produtos")
@RequestMapping("/api/produtos")
public interface ProdutoController {

    @Operation(summary = "Cadastrar um produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto cadastrado com sucesso"),
            @ApiResponse(responseCode = "409", description = "Requisição inválida",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConflictException.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = InternalServerErrorException.class))})
    })
    @PostMapping
    ResponseEntity<ProdutoResponseModel> cadastrar(@RequestBody ProdutoCadastrarRequestModel produtoCadastrarRequestModel);

    @Operation(summary = "Editar um produto pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto editado com sucesso"),
            @ApiResponse(responseCode = "409", description = "Requisição inválida",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConflictException.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = InternalServerErrorException.class))})
    })
    @PutMapping("/{id}")
    ResponseEntity<ProdutoResponseModel> editar(@PathVariable Long id, @RequestBody ProdutoRequestModel produtoRequestModel);

    @Operation(summary = "Remover um produto pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto removido com sucesso"),
            @ApiResponse(responseCode = "409", description = "Requisição inválida",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConflictException.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = InternalServerErrorException.class))})
    })
    @DeleteMapping("/{id}")
    ResponseEntity<ProdutoResponseModel> remover(@PathVariable Long id);
}
