package com.fiappostech.burgerbox.infraestructure.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedido_pagamento", schema = "public")
public class PedidoPagamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private PedidoEntity pedido;

    @Column(name = "pagamento_id")
    private Long pagamentoId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusPagamentoEnum status;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;
}
