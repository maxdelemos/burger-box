package com.fiappostech.burgerbox.infraestructure.configuration;

// Possibilita que o Spring consiga gerenciar os usecases.

import com.fiappostech.burgerbox.core.entity.produto.CategoriaFactory;
import com.fiappostech.burgerbox.core.entity.produto.factory.CategoriaCommonFactory;
import com.fiappostech.burgerbox.core.entity.produto.factory.Produto;
import com.fiappostech.burgerbox.core.gateway.ClienteGateway;
import com.fiappostech.burgerbox.core.gateway.ProdutoGateway;
import com.fiappostech.burgerbox.core.usecase.cliente.CadastrarClienteUseCaseImpl;
import com.fiappostech.burgerbox.core.usecase.cliente.IdentificarClienteUseCaseImpl;
import com.fiappostech.burgerbox.core.usecase.produto.CadastrarProdutoUseCaseImpl;
import com.fiappostech.burgerbox.core.usecase.produto.EditarProdutoUseCaseImpl;
import com.fiappostech.burgerbox.core.usecase.produto.RemoverProdutoUseCaseImpl;
import com.fiappostech.burgerbox.infraestructure.controller.produto.response.ProdutoPresenter;
import com.fiappostech.burgerbox.infraestructure.controller.produto.response.ProdutoResponseFormatter;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
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
    public Produto produto() {
        return new Produto();
    }

    @Bean
    public CategoriaCommonFactory categoriaCommonFactory() {
        return new CategoriaCommonFactory();
    }

    @Bean
    public ProdutoPresenter produtoPresenter() {
        return new ProdutoResponseFormatter();
    }

    @Bean
    public CadastrarProdutoUseCaseImpl cadastrarProduto(ProdutoGateway produtoGateway, ProdutoPresenter produtoPresenter, Produto produtoFactory, CategoriaFactory categoriaFactory) {
        return new CadastrarProdutoUseCaseImpl(produtoGateway, produtoPresenter, categoriaFactory);
    }

    @Bean
    public EditarProdutoUseCaseImpl editarProduto() {
        return new EditarProdutoUseCaseImpl();
    }

    @Bean
    public RemoverProdutoUseCaseImpl removerProduto() {
        return new RemoverProdutoUseCaseImpl();
    }
}
