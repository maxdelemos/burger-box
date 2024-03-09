package com.fiappostech.burgerbox.core.usecase.pedido;

import com.fiappostech.burgerbox.core.entity.cliente.Cliente;
import com.fiappostech.burgerbox.core.entity.pedido.Pedido;
import com.fiappostech.burgerbox.core.entity.pedido.PedidoFactory;
import com.fiappostech.burgerbox.core.entity.pedido.PedidoItem;
import com.fiappostech.burgerbox.core.entity.pedido.PedidoItemFactory;
import com.fiappostech.burgerbox.core.entity.produto.Produto;
import com.fiappostech.burgerbox.core.gateway.ClienteGateway;
import com.fiappostech.burgerbox.core.gateway.MercadoPagoGateway;
import com.fiappostech.burgerbox.core.gateway.PedidoGateway;
import com.fiappostech.burgerbox.core.gateway.ProdutoGateway;
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

    public CadastrarPedidoInteractor(
            PedidoGateway pedidoGateway,
            ClienteGateway clienteGateway,
            ProdutoGateway produtoGateway,
            PedidoPresenter pedidoPresenter,
            PedidoFactory pedidoFactory,
            PedidoItemFactory pedidoItemFactory, MercadoPagoGateway mercadoPagoGateway) {
        this.pedidoGateway = pedidoGateway;
        this.clienteGateway = clienteGateway;
        this.produtoGateway = produtoGateway;
        this.pedidoPresenter = pedidoPresenter;
        this.pedidoFactory = pedidoFactory;
        this.pedidoItemFactory = pedidoItemFactory;
        this.mercadoPagoGateway = mercadoPagoGateway;
    }

    @Override
    public PedidoResponseModel execute(PedidoRequestModel pedidoRequestModel) {
        if (Objects.isNull(pedidoRequestModel.getClienteId())) {
            return pedidoPresenter.prepareFailView("O id do cliente é obrigatório.");
        }

        Cliente cliente = clienteGateway.buscarPorId(pedidoRequestModel.getClienteId());
        if (Objects.isNull(cliente)) {
            return pedidoPresenter.prepareFailView("O cliente não foi encontrado.");
        }

//        // valida se todas os produtos existem
//        List<Produto> produtosEncontrados = produtoGateway.buscarPorIdsAtivo(pedidoRequestModel
//                .getProduto()
//                .stream()
//                .map(PedidoProdutoRequestModel::getId)
//                .toList()
//        );
//
//        if (pedidoRequestModel.getProduto().size() != produtosEncontrados.size()) {
//            List<Long> idsProdutosEncontrados = produtosEncontrados
//                    .stream()
//                    .map(Produto::getId)
//                    .toList();
//            List<PedidoProdutoRequestModel> produtosNaoEncontradas = pedidoRequestModel.getProduto()
//                    .stream()
//                    .filter(produto -> !idsProdutosEncontrados.contains(produto.getId()))
//                    .toList();
//            String idsFormatado = produtosNaoEncontradas.stream()
//                    .map(PedidoProdutoRequestModel::getId).
//                    map(Object::toString)
//                    .collect(Collectors.joining(","));
//
//            return pedidoPresenter.prepareFailView(
//                    String.format("Produtos(s) não encontrado(s): %s", idsFormatado)
//            );
//        }

        List<PedidoItem> pedidoItems = pedidoRequestModel.getProduto()
                .stream()
                .map(produto -> pedidoItemFactory.create(produto.getId(), produto.getQuantidade()))
                .toList();

        Pedido novoPedido = pedidoFactory.create(
                pedidoRequestModel.getClienteId(),
                pedidoItems
        );

        Pedido pedidoCadastrado = pedidoGateway.cadastrar(novoPedido);
        pedidoGateway.buscarPorIdTeste(pedidoCadastrado.getId());

        Double valorPedido = pedidoCadastrado.getPedidoItem()
                .stream()
                .map(pedidoItem -> pedidoItem.getQuantidade() * pedidoItem.getPreco())
                .reduce(0.0, Double::sum);

        mercadoPagoGateway.gerarPagamento(valorPedido);

        return pedidoPresenter.prepareSuccessView(new PedidoResponseModel(pedidoCadastrado.getId()));
    }
}
