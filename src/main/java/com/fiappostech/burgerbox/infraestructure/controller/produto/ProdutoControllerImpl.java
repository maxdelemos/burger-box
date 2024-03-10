package com.fiappostech.burgerbox.infraestructure.controller.produto;

import com.fiappostech.burgerbox.core.usecase.produto.CadastrarProdutoBoundary;
import com.fiappostech.burgerbox.core.usecase.produto.EditarProdutoBoundary;
import com.fiappostech.burgerbox.core.usecase.produto.RemoverProdutoBoundary;
import com.fiappostech.burgerbox.infraestructure.controller.produto.request.ProdutoCadastrarRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.produto.request.ProdutoRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.produto.response.ProdutoResponseModel;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ProdutoControllerImpl implements ProdutoController {
    private final CadastrarProdutoBoundary cadastrarProdutoBoundary;
    private final EditarProdutoBoundary editarProdutoBoundary;
    private final RemoverProdutoBoundary removerProdutoUseCase;

    @PostMapping
    public ResponseEntity<ProdutoResponseModel> cadastrar(@RequestBody ProdutoCadastrarRequestModel produtoCadastrarRequestModel) {
        ProdutoResponseModel responseModel = cadastrarProdutoBoundary.execute(produtoCadastrarRequestModel);
        return ResponseEntity.ok(responseModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseModel> editar(@PathVariable Long id, @RequestBody ProdutoRequestModel produtoRequestModel) {
        ProdutoResponseModel responseModel = editarProdutoBoundary.execute(id, produtoRequestModel);
        return ResponseEntity.ok(responseModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoResponseModel> remover(@PathVariable Long id) {
        ProdutoResponseModel responseModel = removerProdutoUseCase.execute(id);
        return ResponseEntity.ok(responseModel);
    }
}
