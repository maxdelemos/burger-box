package com.fiappostech.burgerbox.infraestructure.configuration;

// Possibilita que o Spring consiga gerenciar os usecases.

import com.fiappostech.burgerbox.core.entity.cliente.ClienteFactory;
import com.fiappostech.burgerbox.core.entity.cliente.ClienteFactoryImpl;
import com.fiappostech.burgerbox.core.entity.pagamento.PagamentoFactory;
import com.fiappostech.burgerbox.core.entity.pagamento.PagamentoFactoryImpl;
import com.fiappostech.burgerbox.core.entity.pedido.*;
import com.fiappostech.burgerbox.core.entity.produto.CategoriaFactory;
import com.fiappostech.burgerbox.core.entity.produto.CategoriaFactoryImpl;
import com.fiappostech.burgerbox.core.entity.produto.ProdutoFactory;
import com.fiappostech.burgerbox.core.entity.produto.ProdutoFactoryImpl;
import com.fiappostech.burgerbox.core.gateway.*;
import com.fiappostech.burgerbox.core.usecase.cliente.CadastrarClienteInteractor;
import com.fiappostech.burgerbox.core.usecase.cliente.IdentificarClienteInteractor;
import com.fiappostech.burgerbox.core.usecase.pedido.*;
import com.fiappostech.burgerbox.core.usecase.produto.CadastrarProdutoInteractor;
import com.fiappostech.burgerbox.core.usecase.produto.EditarProdutoInteractor;
import com.fiappostech.burgerbox.core.usecase.produto.RemoverProdutoInteractor;
import com.fiappostech.burgerbox.infraestructure.controller.cliente.response.ClientePresenter;
import com.fiappostech.burgerbox.infraestructure.controller.cliente.response.ClientePresenterFormatter;
import com.fiappostech.burgerbox.infraestructure.controller.cliente.response.IdentificarClientePresenter;
import com.fiappostech.burgerbox.infraestructure.controller.cliente.response.IdentificarClientePresenterFormatter;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.response.*;
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
    public ClientePresenter clientePresenter() {
        return new ClientePresenterFormatter();
    }

    @Bean
    public IdentificarClientePresenter identificarClientePresenter() {
        return new IdentificarClientePresenterFormatter();
    }

    @Bean
    public CadastrarClienteInteractor cadastrarClienteInteractor(
            ClienteGateway clienteGateway,
            ClienteFactory clienteFactory,
            ClientePresenter clientePedidoPresenter
    ) {
        return new CadastrarClienteInteractor(
                clienteGateway,
                clienteFactory,
                clientePedidoPresenter
        );
    }

    @Bean
    public IdentificarClienteInteractor identificarCliente(
            ClienteGateway clienteGateway,
            ClienteFactory clienteFactory,
            IdentificarClientePresenter identificarClientePresenter
    ) {
        return new IdentificarClienteInteractor(
                clienteGateway,
                clienteFactory,
                identificarClientePresenter
        );
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
    public PagamentoFactory mpPagamentoFactory() {
        return new PagamentoFactoryImpl();
    }

    @Bean
    public AtualizarPedidoPresenter atualizarPedidoPresenter() {
        return new AtualizarPedidoResponseFormatter();
    }

    @Bean
    public PedidoPagamentoFactory pagamentoFactory() {
        return new PedidoPagamentoFactoryImpl();
    }

    @Bean
    public ConsultarPagamentoPresenter consultarPagamentoPresenter() {
        return new ConsultarPagamentoResponseFormatter();
    }

    @Bean
    public CadastrarProdutoInteractor cadastrarProdutoInteractor(
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
    public EditarProdutoInteractor editarProdutoInteractor(
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
    public RemoverProdutoInteractor removerProdutoInteractor(
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
            MercadoPagoGateway mercadoPagoGateway,
            PagamentoFactory pagamentoFactory,
            PedidoPagamentoFactory pedidoPagamentoFactory,
            PedidoPagamentoGateway pedidoPagamentoGateway
    ) {
        return new CadastrarPedidoInteractor(
                pedidoGateway,
                clienteGateway,
                produtoGateway,
                pedidoPresenter,
                pedidoFactory,
                pedidoItemFactory,
                mercadoPagoGateway,
                pagamentoFactory,
                pedidoPagamentoFactory,
                pedidoPagamentoGateway);
    }

    @Bean
    public AtualizarPedidoInteractor atualizarPedidoInteractor(
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
    public ListarPedidoInteractor listarPedidoInteractor(
            PedidoGateway pedidoGateway,
            PedidoPresenter pedidoPresenter
    ) {
        return new ListarPedidoInteractor(
                pedidoGateway,
                pedidoPresenter
        );
    }

    @Bean
    public WebhookPagamentoInteractor webhookPagamentoInteractor(
            MercadoPagoGateway mercadoPagoGateway,
            PedidoPagamentoGateway pedidoPagamentoGateway,
            PedidoFactory pedidoFactory,
            PedidoPagamentoFactory pedidoPagamentoFactory,
            PedidoGateway pedidoGateway
    ) {
        return new WebhookPagamentoInteractor(
                mercadoPagoGateway,
                pedidoPagamentoGateway,
                pedidoFactory,
                pedidoPagamentoFactory,
                pedidoGateway
        );
    }

    @Bean
    public ConsultarPagamentoPedidoInteractor consultarPagamentoPedidoInteractor(
            PedidoPagamentoGateway pedidoPagamentoGateway,
            ConsultarPagamentoPresenter consultarPagamentoPresenter
    ) {
        return new ConsultarPagamentoPedidoInteractor(
                pedidoPagamentoGateway,
                consultarPagamentoPresenter
        );
    }
}
