package com.fiappostech.burgerbox.adapter.controller.pessoa;

import com.fiappostech.burgerbox.domain.usecase.pessoa.cadastrar.CadastrarPessoaInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Pessoas", description = "Api de pessoas")
public class PessoaControllerImpl implements PessoaController {

    @Operation(
            summary = "Cadastrar pessoa",
            description = "Este endpoint permite cadastrar uma nova pessoa no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pessoa cadastrada com sucesso")
    })
    @Override
    public ResponseEntity<Object> cadastrar(CadastrarPessoaInput pessoaInput) {
        return null;
    }
}
