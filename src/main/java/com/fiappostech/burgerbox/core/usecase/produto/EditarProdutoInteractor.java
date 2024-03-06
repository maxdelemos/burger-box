package com.fiappostech.burgerbox.core.usecase.produto;

import com.fiappostech.burgerbox.core.entity.produto.Categoria;
import com.fiappostech.burgerbox.core.entity.produto.Produto;
import com.fiappostech.burgerbox.core.entity.produto.ProdutoFactory;
import com.fiappostech.burgerbox.core.gateway.CategoriaGateway;
import com.fiappostech.burgerbox.core.gateway.ProdutoGateway;
import com.fiappostech.burgerbox.infraestructure.controller.produto.request.CategoriaRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.produto.request.ProdutoRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.produto.response.CategoriaResponseModel;
import com.fiappostech.burgerbox.infraestructure.controller.produto.response.ProdutoPresenter;
import com.fiappostech.burgerbox.infraestructure.controller.produto.response.ProdutoResponseModel;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EditarProdutoInteractor implements EditarProdutoBoundary {
    private final ProdutoGateway produtoGateway;
    private final CategoriaGateway categoriaGateway;
    private final ProdutoPresenter produtoPresenter;
    private final ProdutoFactory produtoFactory;

    public EditarProdutoInteractor(ProdutoGateway produtoGateway, CategoriaGateway categoriaGateway, ProdutoPresenter produtoPresenter, ProdutoFactory produtoFactory) {
        this.produtoGateway = produtoGateway;
        this.categoriaGateway = categoriaGateway;
        this.produtoPresenter = produtoPresenter;
        this.produtoFactory = produtoFactory;
    }

    @Override
    public ProdutoResponseModel execute(Long id, ProdutoRequestModel produtoRequestModel) {
        // verifica se os ids são iguais
        if (!Objects.equals(id, produtoRequestModel.getId())) {
            return produtoPresenter.prepareFailView("O id da request está diferente do id que está no corpo da request.");
        }

        // valida se contém no mínimo uma categoria
        if (produtoRequestModel.getCategorias().isEmpty()) {
            return produtoPresenter.prepareFailView("É necessário enviar pelo menos uma categoria.");
        }

        // verifica se o preço é maior que 0
        if (Boolean.FALSE.equals(produtoRequestModel.getPreco() > 0)) {
            return produtoPresenter.prepareFailView("O preço deve ser maior que zero.");
        }

        Produto produtoEncontrado = produtoGateway.buscarPorIdAtivo(id);

        // verifica se o produto existe
        if (Objects.isNull(produtoEncontrado)) {
            return produtoPresenter.prepareFailView("Produto não existe.");
        }

        // remove possíveis categorias repetidas
        List<CategoriaRequestModel> categoriaResponseModelUnicas = produtoRequestModel
                .getCategorias()
                .stream()
                .collect(Collectors.toMap(
                                CategoriaRequestModel::getCodigo, categoria ->
                                        categoria, (categoria1, categoria2) -> categoria1
                        )
                )
                .values()
                .stream()
                .toList();

        // valida se todas as categorias existem
        List<Categoria> categoriasEncontradas = categoriaGateway.buscarPorCodigos(categoriaResponseModelUnicas
                .stream()
                .distinct()
                .map(CategoriaRequestModel::getCodigo)
                .toList()
        );

        if (categoriasEncontradas.size() != categoriaResponseModelUnicas.size()) {
            List<String> codigosCategoriasEncontradas = categoriasEncontradas.stream()
                    .map(Categoria::getCodigo)
                    .toList();
            List<CategoriaRequestModel> categoriasNaoEncontradas = categoriaResponseModelUnicas.stream()
                    .filter(categoria -> !codigosCategoriasEncontradas.contains(categoria.getCodigo()))
                    .toList();
            String idsFormatado = categoriasNaoEncontradas.stream()
                    .map(CategoriaRequestModel::getCodigo).
                    map(Object::toString)
                    .collect(Collectors.joining(","));

            return produtoPresenter.prepareFailView(
                    String.format("Categoria(s) não encontrada(s): %s",
                            idsFormatado
                    )
            );
        }

        // Faz o mapper da model para a dto do core
        Produto produto = produtoFactory.create(
                produtoRequestModel.getId(),
                produtoRequestModel.getNome(),
                produtoRequestModel.getPreco(),
                produtoRequestModel.getDescricao(),
                produtoRequestModel.getImagem(),
                categoriasEncontradas,
                produtoEncontrado.getDataCriacao()
        );

        // edita o produto
        Produto produtoEditado = produtoGateway.editar(produto);

        // faz o mapper da dto do core para a ResponseModel
        List<CategoriaResponseModel> categoriaResponseModels = produtoEditado
                .getCategorias().stream()
                .map(categoria -> new CategoriaResponseModel(
                        categoria.getId(),
                        categoria.getDescricao(),
                        categoria.getCodigo()))
                .toList();

        ProdutoResponseModel produtoResponseModel = new ProdutoResponseModel(
                produtoEditado.getId(),
                produtoEditado.getNome(),
                produtoEditado.getDescricao(),
                produtoEditado.getImagem(),
                categoriaResponseModels,
                produtoEditado.getPreco(),
                produtoEditado.getAtivo(),
                produtoEditado.getDataCriacao(),
                produtoEditado.getDataAtualizacao()
        );

        return produtoPresenter.prepareSuccessView(produtoResponseModel);
    }
}
