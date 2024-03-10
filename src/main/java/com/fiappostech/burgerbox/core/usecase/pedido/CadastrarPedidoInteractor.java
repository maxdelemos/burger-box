package com.fiappostech.burgerbox.core.usecase.pedido;

import com.fiappostech.burgerbox.core.entity.cliente.Cliente;
import com.fiappostech.burgerbox.core.entity.pagamento.Pagamento;
import com.fiappostech.burgerbox.core.entity.pagamento.PagamentoFactory;
import com.fiappostech.burgerbox.core.entity.pedido.*;
import com.fiappostech.burgerbox.core.entity.produto.Produto;
import com.fiappostech.burgerbox.core.gateway.*;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.request.PedidoProdutoRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.request.PedidoRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.response.PedidoPresenter;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.response.PedidoResponseModel;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CadastrarPedidoInteractor implements CadastrarPedidoBoundary {
    private final PedidoGateway pedidoGateway;
    private final ClienteGateway clienteGateway;
    private final ProdutoGateway produtoGateway;
    private final PedidoPresenter pedidoPresenter;
    private final PedidoFactory pedidoFactory;
    private final PedidoItemFactory pedidoItemFactory;
    private final MercadoPagoGateway mercadoPagoGateway;
    private final PagamentoFactory pagamentoFactory;
    private final PedidoPagamentoFactory pedidoPagamentoFactory;
    private final PedidoPagamentoGateway pedidoPagamentoGateway;

    public CadastrarPedidoInteractor(PedidoGateway pedidoGateway, ClienteGateway clienteGateway, ProdutoGateway produtoGateway, PedidoPresenter pedidoPresenter, PedidoFactory pedidoFactory, PedidoItemFactory pedidoItemFactory, MercadoPagoGateway mercadoPagoGateway, PagamentoFactory pagamentoFactory, PedidoPagamentoFactory pedidoPagamentoFactory, PedidoPagamentoGateway pedidoPagamentoGateway) {
        this.pedidoGateway = pedidoGateway;
        this.clienteGateway = clienteGateway;
        this.produtoGateway = produtoGateway;
        this.pedidoPresenter = pedidoPresenter;
        this.pedidoFactory = pedidoFactory;
        this.pedidoItemFactory = pedidoItemFactory;
        this.mercadoPagoGateway = mercadoPagoGateway;
        this.pagamentoFactory = pagamentoFactory;
        this.pedidoPagamentoFactory = pedidoPagamentoFactory;
        this.pedidoPagamentoGateway = pedidoPagamentoGateway;
    }

    @Override
    public PedidoResponseModel execute(PedidoRequestModel pedidoRequestModel) {
        // validation
        if (Objects.isNull(pedidoRequestModel.getClienteId())) {
            return pedidoPresenter.prepareFailView("O id do cliente é obrigatório.");
        }

        // validation
        Cliente cliente = clienteGateway.buscarPorId(pedidoRequestModel.getClienteId());
        if (Objects.isNull(cliente)) {
            return pedidoPresenter.prepareFailView("O cliente não foi encontrado.");
        }

        // validation
        List<Produto> produtosEncontrados = produtoGateway.buscarPorIdsAtivo(pedidoRequestModel.getProduto().stream().map(PedidoProdutoRequestModel::getId).toList());
        if (pedidoRequestModel.getProduto().size() != produtosEncontrados.size()) {
            String idsProdutosnaoEncontradosFormatado = buscarProdutosNaoEncontrados(pedidoRequestModel, produtosEncontrados);
            return pedidoPresenter.prepareFailView(String.format("Produtos(s) não encontrado(s): %s", idsProdutosnaoEncontradosFormatado));
        }

        // mapper
        List<PedidoItem> pedidoItem = pedidoItemModelToEntity(pedidoRequestModel);

        // calcular o valor do pedido
        Double valorPedido = calcularValorPedido(pedidoItem);

        // gerar pagamento
        Pagamento pagamento = mercadoPagoGateway.gerarPagamento(valorPedido);

        // mapper
        Pedido pedidoNovo = pedidoModelToEntity(pedidoRequestModel, pedidoItem, pagamento);

        // cadastrar um novo pedido
        Pedido pedidoCadastrado = pedidoGateway.cadastrar(pedidoNovo);

        // cadastrar a relação do pagamento com o pedido
        // PedidoPagamento pedidoPagamento = pedidoPagamentoFactory.create(null, pedidoCadastrado.getId(), pagamento.getId(), pagamento.getStatus());

        // pedidoPagamentoGateway.cadastrar(pedidoPagamento);

        return pedidoPresenter.prepareSuccessView(
                new PedidoResponseModel
                        (
                                pedidoCadastrado.getId(),
                                pagamento.getQrcodePix(),
                                pagamento.getCodigoPix()
                        )
        );
    }

    private Double calcularValorPedido(List<PedidoItem> pedidoItem) {
        return pedidoItem.stream().map(pi -> {
            Produto produto = produtoGateway.buscarPorIdAtivo(pi.geProdutoId());
            return pi.getQuantidade() * produto.getPreco();
        }).reduce(0.0, Double::sum);
    }

    private Pedido pedidoModelToEntity(PedidoRequestModel pedidoRequestModel, List<PedidoItem> pedidoItem, Pagamento pagamento) {
        return pedidoFactory.create(pedidoRequestModel.getClienteId(), pedidoItem, pagamento);
    }

    private List<PedidoItem> pedidoItemModelToEntity(PedidoRequestModel pedidoRequestModel) {
        return pedidoRequestModel.getProduto().stream().map(produto -> pedidoItemFactory.create(produto.getId(), produto.getQuantidade())).toList();
    }

    private String buscarProdutosNaoEncontrados(PedidoRequestModel pedidoRequestModel, List<Produto> produtosEncontrados) {
        List<Long> idsProdutosEncontrados = produtosEncontrados.stream().map(Produto::getId).toList();
        List<PedidoProdutoRequestModel> produtosNaoEncontradas = pedidoRequestModel.getProduto().stream().filter(produto -> !idsProdutosEncontrados.contains(produto.getId())).toList();
        return produtosNaoEncontradas.stream().map(PedidoProdutoRequestModel::getId).map(Object::toString).collect(Collectors.joining(","));
    }
}
