package com.fiappostech.burgerbox.infraestructure.configuration;

// Possibilita que o Spring consiga gerenciar os usecases.

import com.fiappostech.burgerbox.core.entity.produto.*;
import com.fiappostech.burgerbox.core.gateway.CategoriaGateway;
import com.fiappostech.burgerbox.core.gateway.ClienteGateway;
import com.fiappostech.burgerbox.core.gateway.ProdutoGateway;
import com.fiappostech.burgerbox.core.usecase.cliente.CadastrarClienteUseCaseImpl;
import com.fiappostech.burgerbox.core.usecase.cliente.IdentificarClienteUseCaseImpl;
import com.fiappostech.burgerbox.core.usecase.produto.CadastrarProdutoInteractor;
import com.fiappostech.burgerbox.core.usecase.produto.EditarProdutoInteractor;
import com.fiappostech.burgerbox.core.usecase.produto.RemoverProdutoInteractor;
import com.fiappostech.burgerbox.infraestructure.controller.produto.response.ProdutoPresenter;
import com.fiappostech.burgerbox.infraestructure.controller.produto.response.ProdutoResponseFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public CadastrarClienteUseCaseImpl criarPessoaUseCase(ClienteGateway clienteGateway) {
        return new CadastrarClienteUseCaseImpl(clienteGateway);
    }

    @Bean
    public IdentificarClienteUseCaseImpl identificarCliente(ClienteGateway clienteGateway) {
        return new IdentificarClienteUseCaseImpl(clienteGateway);
    }

    @Bean
    public ProdutoFactory produtoFactory() {
        return new ProdutoFactoryImpl();
    }

    @Bean
    public CategoriaFactory categoriaCommonFactory() {
        return new CategoriaFactoryImpl();
    }

    @Bean
    public ProdutoPresenter produtoPresenter() {
        return new ProdutoResponseFormatter();
    }

    @Bean
    public CadastrarProdutoInteractor cadastrarProduto(
            ProdutoGateway produtoGateway, CategoriaGateway
            categoriaGateway,
            ProdutoPresenter produtoPresenter,
            ProdutoFactory produtoFactory
    ) {
        return new CadastrarProdutoInteractor(
                produtoGateway,
                categoriaGateway,
                produtoPresenter,
                produtoFactory
        );
    }

    @Bean
    public EditarProdutoInteractor editarProduto(
            ProdutoGateway produtoGateway,
            CategoriaGateway categoriaGateway,
            ProdutoPresenter produtoPresenter,
            ProdutoFactory produtoFactory
    ) {
        return new EditarProdutoInteractor(
                produtoGateway,
                categoriaGateway,
                produtoPresenter, produtoFactory
        );
    }

    @Bean
    public RemoverProdutoInteractor removerProduto(
            ProdutoGateway produtoGateway,
            ProdutoPresenter produtoPresenter
    ) {
        return new RemoverProdutoInteractor(
                produtoGateway,
                produtoPresenter
        );
    }
}
