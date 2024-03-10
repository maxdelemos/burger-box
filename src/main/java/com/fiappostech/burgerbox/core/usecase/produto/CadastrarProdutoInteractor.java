package com.fiappostech.burgerbox.core.usecase.produto;

import com.fiappostech.burgerbox.core.entity.produto.Categoria;
import com.fiappostech.burgerbox.core.entity.produto.Produto;
import com.fiappostech.burgerbox.core.entity.produto.ProdutoFactory;
import com.fiappostech.burgerbox.core.exceptions.BBException;
import com.fiappostech.burgerbox.core.gateway.CategoriaGateway;
import com.fiappostech.burgerbox.core.gateway.ProdutoGateway;
import com.fiappostech.burgerbox.infraestructure.controller.produto.request.CategoriaRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.produto.request.ProdutoCadastrarRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.produto.response.CategoriaResponseModel;
import com.fiappostech.burgerbox.infraestructure.controller.produto.response.ProdutoPresenter;
import com.fiappostech.burgerbox.infraestructure.controller.produto.response.ProdutoResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CadastrarProdutoInteractor implements CadastrarProdutoBoundary {

    private final ProdutoGateway produtoGateway;
    private final CategoriaGateway categoriaGateway;
    private final ProdutoPresenter produtoPresenter;
    private final ProdutoFactory produtoFactory;

    public CadastrarProdutoInteractor(ProdutoGateway produtoGateway, CategoriaGateway categoriaGateway, ProdutoPresenter produtoPresenter, ProdutoFactory produtoFactory) {
        this.produtoGateway = produtoGateway;
        this.categoriaGateway = categoriaGateway;
        this.produtoPresenter = produtoPresenter;
        this.produtoFactory = produtoFactory;
    }

    @Override
    public ProdutoResponseModel execute(ProdutoCadastrarRequestModel produtoCadastrarRequestModel) {
        try {
            // verifica o nome do produto
            String produtoNome = produtoCadastrarRequestModel.getNome();
            if (Objects.isNull(produtoNome) || produtoNome.length() < 3) {
                return produtoPresenter.prepareFailView("O nome do produto deve ter no mínimo 3 letras.");
            }

            // verifica se o produto já existe
            if (Boolean.TRUE.equals(produtoGateway.existePorNomeAtivo(produtoCadastrarRequestModel.getNome()))) {
                return produtoPresenter.prepareFailView("Produto já existe.");
            }

            // verifica se o preço é maior que 0
            if (Boolean.FALSE.equals(produtoCadastrarRequestModel.getPreco() > 0)) {
                return produtoPresenter.prepareFailView("O preço deve ser maior que zero.");
            }

            // valida se contém no mínimo uma categoria
            if (produtoCadastrarRequestModel.getCategorias().isEmpty()) {
                return produtoPresenter.prepareFailView("É necessário enviar pelo menos uma categoria.");
            }

            // valida se todas as categorias existem
            List<Categoria> categoriasEncontradas = categoriaGateway.buscarPorCodigos(produtoCadastrarRequestModel
                    .getCategorias()
                    .stream()
                    .map(CategoriaRequestModel::getCodigo)
                    .toList()
            );

            if (categoriasEncontradas.size() != produtoCadastrarRequestModel.getCategorias().size()) {
                List<String> codigosCategoriasEncontradas = categoriasEncontradas
                        .stream()
                        .map(Categoria::getCodigo)
                        .toList();
                List<CategoriaRequestModel> categoriasNaoEncontradas = produtoCadastrarRequestModel.getCategorias()
                        .stream()
                        .filter(categoria -> !codigosCategoriasEncontradas.contains(categoria.getCodigo()))
                        .toList();
                String idsFormatado = categoriasNaoEncontradas.stream()
                        .map(CategoriaRequestModel::getCodigo).
                        map(Object::toString)
                        .collect(Collectors.joining(","));
                return produtoPresenter.prepareFailView(
                        String.format("Categoria(s) não encontrada(s): %s", idsFormatado)
                );
            }

            // faz o mapper da model para a dto do core
            Produto produto = produtoFactory.create(
                    produtoCadastrarRequestModel.getNome(),
                    produtoCadastrarRequestModel.getPreco(),
                    produtoCadastrarRequestModel.getDescricao(),
                    produtoCadastrarRequestModel.getImagem(),
                    categoriasEncontradas
            );

            // cadastra utilizando o Gateway
            Produto produtoCadastrado = produtoGateway.cadastrar(produto);

            // faz o mapper da dto do core para a ResponseModel
            List<CategoriaResponseModel> categoriaResponseModels = produtoCadastrado.getCategorias()
                    .stream()
                    .map(categoria -> new CategoriaResponseModel(
                            categoria.getId(),
                            categoria.getDescricao(),
                            categoria.getCodigo())
                    )
                    .toList();
            ProdutoResponseModel produtoResponseModel = new ProdutoResponseModel(
                    produtoCadastrado.getId(),
                    produtoCadastrado.getNome(),
                    produtoCadastrado.getDescricao(),
                    produtoCadastrado.getImagem(),
                    categoriaResponseModels,
                    produtoCadastrado.getPreco(),
                    produtoCadastrado.getAtivo(),
                    produtoCadastrado.getDataCriacao(),
                    produtoCadastrado.getDataAtualizacao()
            );

            return produtoPresenter.prepareSuccessView(produtoResponseModel);
        } catch (BBException bbException) {
            throw new BBException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }
}
