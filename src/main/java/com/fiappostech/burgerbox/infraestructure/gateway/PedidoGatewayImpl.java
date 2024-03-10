package com.fiappostech.burgerbox.infraestructure.gateway;

import com.fiappostech.burgerbox.core.entity.pedido.*;
import com.fiappostech.burgerbox.core.gateway.PedidoGateway;
import com.fiappostech.burgerbox.infraestructure.persistence.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PedidoGatewayImpl implements PedidoGateway {
    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;
    private final PedidoFactory pedidoFactory;
    private final PedidoItemFactory pedidoItemFactory;

    @Override
    @Transactional
    public Pedido cadastrar(Pedido pedido) {
        LocalDateTime dataAtual = LocalDateTime.now();
        PedidoEntity novoPedido = new PedidoEntity();

        PedidoPagamentoEntity novoPedidoPagamento = new PedidoPagamentoEntity();
        novoPedidoPagamento.setPedido(novoPedido);
        novoPedidoPagamento.setPagamentoId(pedido.getPagamento().getId());
        novoPedidoPagamento.setStatus(StatusPagamentoEnum.buscarPorCodigo(pedido.getPagamento().getStatus()));
        novoPedidoPagamento.setDataAtualizacao(dataAtual);
        novoPedidoPagamento.setDataCriacao(dataAtual);

        novoPedido.setPedidoPagamento(novoPedidoPagamento);
        novoPedido.setCliente(ClienteEntity.builder().id(pedido.getClienteId()).build());
        List<PedidoItemEntity> produtosEntities = preencherPedidoItem(pedido, novoPedido);
        novoPedido.setPedidoItem(produtosEntities);
        novoPedido.setDataCriacao(dataAtual);
        novoPedido.setDataAtualizacao(dataAtual);

        PedidoEntity pedidoCadastrado = pedidoRepository.saveAndFlush(novoPedido);

        List<PedidoItem> pedidoItems = pedidoCadastrado.getPedidoItem()
                .stream()
                .map(item -> pedidoItemFactory.create(
                        item.getId(),
                        item.getQuantidade(),
                        item.getProduto().getPreco()
                )).toList();

        return pedidoFactory.create(
                pedidoCadastrado.getId(),
                Objects.nonNull(pedidoCadastrado.getStatus()) ? pedidoCadastrado.getStatus().getCodigo() : "",
                pedidoItems,
                pedidoCadastrado.getDataAtualizacao()
        );
    }

    @Override
    public Pedido editar(Pedido pedido) {

        pedidoRepository.atualizarStatus(
                pedido.getId(),
                Objects.nonNull(pedido.getStatus()) ? Objects.requireNonNull(StatusPedidoEnum.buscarPorCodigo(pedido.getStatus())).getCodigo() : ""
        );

        Optional<PedidoEntity> pedidoEditado = pedidoRepository.findById(pedido.getId());

        return pedidoEditado.map(pedidoEntity ->
                pedidoFactory.create(
                        pedidoEntity.getId(),
                        pedidoEntity.getStatus().getCodigo(),
                        pedidoEditado.get().getDataAtualizacao()
                )).orElse(null);
    }

    @Override
    public Boolean statusPedidoExiste(String status) {
        StatusPedidoEnum statusPedidoEnum = StatusPedidoEnum.buscarPorCodigo(status);
        return Objects.nonNull(statusPedidoEnum);
    }

    @Override
    public List<Pedido> listar() {
        List<ListaPedidoProjection> listaPedido = pedidoRepository.listar();
        return listaPedido.stream().map(listaPedidoProjection -> pedidoFactory.create(
                listaPedidoProjection.getId(),
                listaPedidoProjection.getStatus(),
                listaPedidoProjection.getDataAtualizacao()
        )).toList();
    }

    @Override
    public void atualizarPagamento(Long pedidoId) {
        Optional<PedidoEntity> pedidoEntity = pedidoRepository.findById(pedidoId);
        if (pedidoEntity.isPresent()) {
            pedidoEntity.get().setStatus(StatusPedidoEnum.RECEBIDO);
            pedidoEntity.get().setDataAtualizacao(LocalDateTime.now());
            pedidoRepository.saveAndFlush(pedidoEntity.get());
        }

    }

    @Override
    public Pedido buscarPorId(Long id) {
        Optional<PedidoEntity> pedidoEntity = pedidoRepository.findById(id);
        return pedidoEntity.map(entity -> pedidoFactory.create(entity.getId(), entity.getStatus().getCodigo())).orElse(null);
    }

    private List<PedidoItemEntity> preencherPedidoItem(Pedido pedido, PedidoEntity pedidoEntity) {
        return pedido.getPedidoItem()
                .stream()
                .map(produto -> PedidoItemEntity
                        .builder()
                        .produto(produtoRepository.findById(produto.geProdutoId()).get())
                        .pedido(pedidoEntity)
                        .quantidade(produto.getQuantidade())
                        .dataCriacao(LocalDateTime.now())
                        .dataAtualizacao(LocalDateTime.now())
                        .build()
                )
                .toList();
    }
}
