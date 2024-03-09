package com.fiappostech.burgerbox.infraestructure.gateway;

import com.fiappostech.burgerbox.core.entity.pedido.Pedido;
import com.fiappostech.burgerbox.core.entity.pedido.PedidoFactory;
import com.fiappostech.burgerbox.core.entity.pedido.PedidoItem;
import com.fiappostech.burgerbox.core.entity.pedido.PedidoItemFactory;
import com.fiappostech.burgerbox.core.gateway.PedidoGateway;
import com.fiappostech.burgerbox.infraestructure.persistence.cliente.ClienteEntity;
import com.fiappostech.burgerbox.infraestructure.persistence.enums.StatusPedidoEnum;
import com.fiappostech.burgerbox.infraestructure.persistence.pedido.ListaPedidoProjection;
import com.fiappostech.burgerbox.infraestructure.persistence.pedido.PedidoEntity;
import com.fiappostech.burgerbox.infraestructure.persistence.pedido.PedidoRepository;
import com.fiappostech.burgerbox.infraestructure.persistence.pedidoItem.PedidoItemEntity;
import com.fiappostech.burgerbox.infraestructure.persistence.produto.ProdutoEntity;
import com.fiappostech.burgerbox.infraestructure.persistence.produto.ProdutoRepository;
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
        PedidoEntity pedidoEntity = new PedidoEntity();

        List<PedidoItemEntity> produtosEntities = preencherPedidoItem(pedido, pedidoEntity);

        pedidoEntity.setCliente(ClienteEntity.builder().id(pedido.getClienteId()).build());
        StatusPedidoEnum statusPedido = StatusPedidoEnum.RECEBIDO;
        pedidoEntity.setStatus(statusPedido);
        pedidoEntity.setPedidoItem(produtosEntities);
        pedidoEntity.setDataCriacao(LocalDateTime.now());
        pedidoEntity.setDataAtualizacao(LocalDateTime.now());

        PedidoEntity pedidoCadastrado = pedidoRepository.saveAndFlush(pedidoEntity);

        List<PedidoItem> pedidoItems = pedidoCadastrado.getPedidoItem().stream().map(item -> pedidoItemFactory.create(
                item.getId(),
                item.getQuantidade(),
                item.getProduto().getPreco()
        )).toList();

        return pedidoFactory.create(
                pedidoCadastrado.getId(),
                pedidoCadastrado.getStatus().getCodigo(),
                pedidoItems,
                pedidoCadastrado.getDataAtualizacao()
        );
    }

    @Override
    public Pedido editar(Pedido pedido) {

        pedidoRepository.atualizarStatus(
                pedido.getId(),
                Objects.requireNonNull(StatusPedidoEnum.buscarPorCodigo(pedido.getStatus())).getCodigo()
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
    public Pedido buscarPorIdTeste(Long id) {
        PedidoEntity pedido = pedidoRepository.buscarPorIdTeste(id);
        return null;
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
                        .produto(produtoRepository.findById(produto.getId()).get())
                        .pedido(pedidoEntity)
                        .quantidade(produto.getQuantidade())
                        .dataCriacao(LocalDateTime.now())
                        .dataAtualizacao(LocalDateTime.now())
                        .build()
                )
                .toList();
    }
}
