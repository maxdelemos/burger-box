package com.fiappostech.burgerbox.infraestructure.controller.produto;

import com.fiappostech.burgerbox.core.entity.produto.factory.Produto;
import com.fiappostech.burgerbox.core.usecase.produto.CadastrarProdutoUseCase;
import com.fiappostech.burgerbox.core.usecase.produto.EditarProdutoUseCase;
import com.fiappostech.burgerbox.core.usecase.produto.RemoverProdutoUseCase;
import com.fiappostech.burgerbox.infraestructure.controller.produto.request.ProdutoRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.produto.response.ProdutoResponseModel;
import com.fiappostech.burgerbox.infraestructure.dto.produto.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produtos")
@AllArgsConstructor
public class ProdutoController {
    private final CadastrarProdutoUseCase cadastrarProdutoUseCase;
    private final EditarProdutoUseCase editarProdutoUseCase;
    private final RemoverProdutoUseCase removerProdutoUseCase;

    @PostMapping
    public ResponseEntity<ProdutoResponseModel> cadastrar(@RequestBody ProdutoRequestModel produtoRequestModel) {
        ProdutoResponseModel responseModel = cadastrarProdutoUseCase.execute(produtoRequestModel);
        return ResponseEntity.ok(responseModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EditarProdutoOutput> editar(@PathVariable Long id, @RequestBody EditarProdutoInput editarProdutoInput) {
        Produto editadoProdutoDomain = editarProdutoUseCase.execute(null);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        removerProdutoUseCase.execute(null);
        return ResponseEntity.ok().build();
    }
}
