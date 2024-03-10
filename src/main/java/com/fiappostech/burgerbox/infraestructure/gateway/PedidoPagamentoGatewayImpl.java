package com.fiappostech.burgerbox.infraestructure.gateway;

import com.fiappostech.burgerbox.core.entity.pedido.Pedido;
import com.fiappostech.burgerbox.core.entity.pedido.PedidoPagamento;
import com.fiappostech.burgerbox.core.entity.pedido.PedidoPagamentoFactory;
import com.fiappostech.burgerbox.core.gateway.PedidoPagamentoGateway;
import com.fiappostech.burgerbox.infraestructure.persistence.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PedidoPagamentoGatewayImpl implements PedidoPagamentoGateway {
    private final PedidoPamentoRepository pedidoPamentoRepository;
    private final PedidoRepository pedidoRepository;
    private final PedidoPagamentoFactory pedidoPagamentoFactory;

    @Override
    public PedidoPagamento cadastrar(PedidoPagamento pedido) {
        LocalDateTime data = LocalDateTime.now();
        PedidoPagamentoEntity pedidoPagamento = new PedidoPagamentoEntity();
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setId(pedido.getPedidoId());

        pedidoPagamento.setPagamentoId(pedido.getPagamentoId());
        pedidoPagamento.setStatus(StatusPagamentoEnum.buscarPorCodigo(pedido.getStatus()));
        pedidoPagamento.setDataAtualizacao(data);
        pedidoPagamento.setDataCriacao(data);

        pedidoPamentoRepository.saveAndFlush(pedidoPagamento);
        return null;
    }

    @Override
    public PedidoPagamento buscarPorPagamentoId(Long pagamentoId) {
        PedidoPagamentoEntity pedidoPagamentoEntity = pedidoPamentoRepository.buscarPorPagamentoId(pagamentoId);
        if (Objects.nonNull(pedidoPagamentoEntity)) {
            return pedidoPagamentoFactory.create(
                    pedidoPagamentoEntity.getId(),
                    pedidoPagamentoEntity.getPedido().getId(),
                    pedidoPagamentoEntity.getPagamentoId(),
                    pedidoPagamentoEntity.getStatus().getCodigo()
            );
        }
        return null;
    }

    @Override
    public void atualizarPagamento(Long id) {
        Optional<PedidoPagamentoEntity> pedidoPagamentoEntity = pedidoPamentoRepository.findById(id);
        if (pedidoPagamentoEntity.isPresent()) {
            pedidoPagamentoEntity.get().setId(id);
            pedidoPagamentoEntity.get().setDataAtualizacao(LocalDateTime.now());
            pedidoPagamentoEntity.get().setStatus(StatusPagamentoEnum.APROVADO);
            pedidoPamentoRepository.saveAndFlush(pedidoPagamentoEntity.get());
        }
    }

    @Override
    public PedidoPagamento consultarPagamento(Long pedidoId) {
        PedidoPagamentoEntity pedidoPagamento = pedidoPamentoRepository.buscarPorPedidoId(pedidoId);
        if (Objects.nonNull(pedidoPagamento)) {
            return pedidoPagamentoFactory.create(
                    pedidoPagamento.getId(),
                    pedidoPagamento.getPedido().getId(),
                    pedidoPagamento.getPagamentoId(),
                    pedidoPagamento.getStatus().getCodigo()
            );
        }
        return null;
    }
}
