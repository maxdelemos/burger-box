package com.fiappostech.burgerbox.infraestructure.gateway;

import com.fiappostech.burgerbox.core.entity.pedido.Pedido;
import com.fiappostech.burgerbox.core.entity.pedido.PedidoFactory;
import com.fiappostech.burgerbox.core.gateway.PedidoGateway;
import com.fiappostech.burgerbox.infraestructure.persistence.cliente.ClienteEntity;
import com.fiappostech.burgerbox.infraestructure.persistence.pedido.PedidoEntity;
import com.fiappostech.burgerbox.infraestructure.persistence.pedido.PedidoRepository;
import com.fiappostech.burgerbox.infraestructure.persistence.pedidoItem.PedidoItemEntity;
import com.fiappostech.burgerbox.infraestructure.persistence.produto.ProdutoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PedidoGatewayImpl implements PedidoGateway {
    private final PedidoRepository pedidoRepository;
    private final PedidoFactory pedidoFactory;

    @Override
    public Pedido cadastrar(Pedido pedido) {
        PedidoEntity pedidoEntity = new PedidoEntity();

        List<PedidoItemEntity> produtosEntities = preencherPedidoItem(pedido, pedidoEntity);

        pedidoEntity.setCliente(ClienteEntity.builder().id(pedido.getClienteId()).build());
        pedidoEntity.setPedidoItem(produtosEntities);
        pedidoEntity.setDataCriacao(LocalDateTime.now());
        pedidoEntity.setDataAtualizacao(LocalDateTime.now());

        PedidoEntity pedidoCadastrado = pedidoRepository.saveAndFlush(pedidoEntity);

        return pedidoFactory.create(pedidoCadastrado.getId());
    }

    private static List<PedidoItemEntity> preencherPedidoItem(Pedido pedido, PedidoEntity pedidoEntity) {
        return pedido.getPedidoItem()
                .stream()
                .map(produto -> PedidoItemEntity
                        .builder()
                        .produto(ProdutoEntity.builder().id(produto.getId()).build())
                        .pedido(pedidoEntity)
                        .quantidade(produto.getQuantidade())
                        .dataCriacao(LocalDateTime.now())
                        .dataAtualizacao(LocalDateTime.now())
                        .build()
                )
                .toList();
    }
}
