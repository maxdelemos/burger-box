package com.fiappostech.burgerbox.core.usecase.produto;

import com.fiappostech.burgerbox.core.entity.produto.Produto;
import com.fiappostech.burgerbox.core.gateway.ProdutoGateway;
import com.fiappostech.burgerbox.infraestructure.controller.produto.response.CategoriaResponseModel;
import com.fiappostech.burgerbox.infraestructure.controller.produto.response.ProdutoPresenter;
import com.fiappostech.burgerbox.infraestructure.controller.produto.response.ProdutoResponseModel;

import java.util.List;
import java.util.Objects;

public class RemoverProdutoInteractor implements RemoverProdutoBoundary {
    private final ProdutoGateway produtoGateway;
    private final ProdutoPresenter produtoPresenter;

    public RemoverProdutoInteractor(
            ProdutoGateway produtoGateway,
            ProdutoPresenter produtoPresenter
    ) {
        this.produtoGateway = produtoGateway;
        this.produtoPresenter = produtoPresenter;
    }

    @Override
    public ProdutoResponseModel execute(Long id) {
        Produto produtoEncontrado = produtoGateway.buscarPorIdAtivo(id);

        // verifica se o produto existe
        if (Objects.isNull(produtoEncontrado)) {
            return produtoPresenter.prepareFailView("Produto não existe.");
        }

        // remove o produto
        produtoGateway.remover(produtoEncontrado.getId());

        // faz o mapper da dto do core para a ResponseModel
        List<CategoriaResponseModel> categoriaResponseModels = produtoEncontrado
                .getCategorias().stream()
                .map(categoria -> new CategoriaResponseModel(
                        categoria.getId(),
                        categoria.getDescricao(),
                        categoria.getCodigo()))
                .toList();

        ProdutoResponseModel produtoResponseModel = new ProdutoResponseModel(
                produtoEncontrado.getId(),
                produtoEncontrado.getNome(),
                produtoEncontrado.getDescricao(),
                produtoEncontrado.getImagem(),
                categoriaResponseModels,
                produtoEncontrado.getPreco(),
                Boolean.FALSE,
                produtoEncontrado.getDataCriacao(),
                produtoEncontrado.getDataAtualizacao()
        );

        return produtoPresenter.prepareSuccessView(produtoResponseModel);
    }
}
