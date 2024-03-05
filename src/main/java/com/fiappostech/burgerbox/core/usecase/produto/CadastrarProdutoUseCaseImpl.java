package com.fiappostech.burgerbox.core.usecase.produto;

import com.fiappostech.burgerbox.core.entity.produto.*;
import com.fiappostech.burgerbox.core.entity.produto.factory.Produto;
import com.fiappostech.burgerbox.core.gateway.ProdutoGateway;
import com.fiappostech.burgerbox.infraestructure.controller.produto.response.ProdutoPresenter;
import com.fiappostech.burgerbox.infraestructure.controller.produto.request.ProdutoRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.produto.response.CategoriaResponseModel;
import com.fiappostech.burgerbox.infraestructure.controller.produto.response.ProdutoResponseModel;

import java.util.List;
import java.util.stream.Collectors;

public class CadastrarProdutoUseCaseImpl implements CadastrarProdutoUseCase {

    private final ProdutoGateway produtoGateway;
    private final ProdutoPresenter produtoPresenter;
    private final CategoriaFactory categoriaFactory;

    public CadastrarProdutoUseCaseImpl(ProdutoGateway produtoGateway, ProdutoPresenter produtoPresenter, CategoriaFactory categoriaFactory) {
        this.produtoGateway = produtoGateway;
        this.produtoPresenter = produtoPresenter;
        this.categoriaFactory = categoriaFactory;
    }

    @Override
    public ProdutoResponseModel execute(ProdutoRequestModel produtoRequestModel) {
        boolean produtoEncontrado = produtoGateway.existe(produtoRequestModel.getNome());
        if (produtoEncontrado) {
            return produtoPresenter.prepareFailView("Produto já existe.");
        }

        // TODO: verificar se existe categoria

        // Categoria: mapper da request para entity
        List<Categoria> categorias = produtoRequestModel.getCategorias()
                .stream()
                .map(categoria -> categoriaFactory.create(categoria.getId(), categoria.getDescricao(), categoria.getCodigo()))
                .collect(Collectors.toList());

        // Produto: mapper da request para entity
        Produto produtoCommon = new Produto(
                produtoRequestModel.getNome(),
                produtoRequestModel.getPreco(),
                categorias
        );

        // cadastra o produto usando o gateway
        Produto produtoCadastrado = produtoGateway.cadastrar(produtoCommon);

        // mapper da entity para a response
        List<CategoriaResponseModel> categoriaResponseModels = produtoCadastrado.getCategorias()
                .stream()
                .map(categoria -> CategoriaResponseModel.builder().id(categoria.getId()).codigo(categoria.getCodigo()).descricao(categoria.getDescricao()).build())
                .collect(Collectors.toList());

        ProdutoResponseModel novoProdutoCadastrado = ProdutoResponseModel
                .builder()
                .id(produtoCadastrado.getId())
                .nome(produtoCadastrado.getNome())
                .preco(produtoCadastrado.getPreco())
                .categorias(categoriaResponseModels)
                .build();

        return produtoPresenter.prepareSuccessView(novoProdutoCadastrado);
    }
}
