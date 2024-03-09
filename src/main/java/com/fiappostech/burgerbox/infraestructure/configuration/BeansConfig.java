package com.fiappostech.burgerbox.infraestructure.configuration;

// Possibilita que o Spring consiga gerenciar os usecases.

import com.fiappostech.burgerbox.core.entity.cliente.ClienteFactory;
import com.fiappostech.burgerbox.core.entity.cliente.ClienteFactoryImpl;
import com.fiappostech.burgerbox.core.entity.pedido.*;
import com.fiappostech.burgerbox.core.entity.produto.CategoriaFactory;
import com.fiappostech.burgerbox.core.entity.produto.CategoriaFactoryImpl;
import com.fiappostech.burgerbox.core.entity.produto.ProdutoFactory;
import com.fiappostech.burgerbox.core.entity.produto.ProdutoFactoryImpl;
import com.fiappostech.burgerbox.core.gateway.*;
import com.fiappostech.burgerbox.core.usecase.cliente.CadastrarClienteUseCaseImpl;
import com.fiappostech.burgerbox.core.usecase.cliente.IdentificarClienteUseCaseImpl;
import com.fiappostech.burgerbox.core.usecase.pedido.AtualizarPedidoInteractor;
import com.fiappostech.burgerbox.core.usecase.pedido.CadastrarPedidoInteractor;
import com.fiappostech.burgerbox.core.usecase.pedido.ListarPedidoInteractor;
import com.fiappostech.burgerbox.core.usecase.pedido.WebhookPagamentoInteractor;
import com.fiappostech.burgerbox.core.usecase.produto.CadastrarProdutoInteractor;
import com.fiappostech.burgerbox.core.usecase.produto.EditarProdutoInteractor;
import com.fiappostech.burgerbox.core.usecase.produto.RemoverProdutoInteractor;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.response.AtualizarPedidoPresenter;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.response.AtualizarPedidoResponseFormatter;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.response.PedidoPresenter;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.response.PedidoResponseFormatter;
import com.fiappostech.burgerbox.infraestructure.controller.produto.response.ProdutoPresenter;
import com.fiappostech.burgerbox.infraestructure.controller.produto.response.ProdutoResponseFormatter;
import com.mercadopago.MercadoPagoConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class BeansConfig {
    @Value("${mp.accessToken}")
    private String accessToken;

    @PostConstruct
    public void setAccessTokenMercadoPago() {
        MercadoPagoConfig.setAccessToken(accessToken);
    }

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
    public CategoriaFactory categoriaFactory() {
        return new CategoriaFactoryImpl();
    }

    @Bean
    public ProdutoPresenter produtoPresenter() {
        return new ProdutoResponseFormatter();
    }

    @Bean
    public PedidoPresenter pedidoPresenter() {
        return new PedidoResponseFormatter();
    }

    @Bean
    public ClienteFactory clienteFactory() {
        return new ClienteFactoryImpl();
    }

    @Bean
    public PedidoFactory pedidoFactory() {
        return new PedidoFactoryImpl();
    }

    @Bean
    public PedidoItemFactory pedidoItemFactory() {
        return new PedidoItemFactoryImpl();
    }

    @Bean
    public MPPagamentoFactory mpPagamentoFactory() {
        return new MPPagamentoFactoryImpl();
    }

    @Bean
    public AtualizarPedidoPresenter atualizarPedidoPresenter() {
        return new AtualizarPedidoResponseFormatter();
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

    @Bean
    public CadastrarPedidoInteractor cadastrarPedidoInteractor(
            PedidoGateway pedidoGateway,
            ClienteGateway clienteGateway,
            ProdutoGateway produtoGateway,
            PedidoPresenter pedidoPresenter,
            PedidoFactory pedidoFactory,
            PedidoItemFactory pedidoItemFactory,
            MercadoPagoGateway mercadoPagoGateway
    ) {
        return new CadastrarPedidoInteractor(
                pedidoGateway,
                clienteGateway,
                produtoGateway,
                pedidoPresenter,
                pedidoFactory,
                pedidoItemFactory,
                mercadoPagoGateway
        );
    }

    @Bean
    public AtualizarPedidoInteractor AtualizarPedidoInteractor(
            PedidoGateway pedidoGateway,
            PedidoFactory pedidoFactory,
            AtualizarPedidoPresenter atualizarPedidoPresenter
    ) {
        return new AtualizarPedidoInteractor(
                pedidoGateway,
                pedidoFactory,
                atualizarPedidoPresenter
        );
    }

    @Bean
    public ListarPedidoInteractor ListarPedidoInteractor(PedidoGateway pedidoGateway, PedidoPresenter pedidoPresenter) {
        return new ListarPedidoInteractor(
                pedidoGateway,
                pedidoPresenter
        );
    }

    @Bean
    public WebhookPagamentoInteractor webhookPagamentoInteractor(
            MercadoPagoGateway mercadoPagoGateway
    ) {
        return new WebhookPagamentoInteractor(
                mercadoPagoGateway
        );
    }
}
