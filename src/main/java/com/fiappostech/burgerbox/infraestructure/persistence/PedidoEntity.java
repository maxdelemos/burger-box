package com.fiappostech.burgerbox.infraestructure.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@ToString
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pedido", schema = "public")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusPedidoEnum status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private ClienteEntity cliente;

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PedidoPagamentoEntity pedidoPagamento;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<PedidoItemEntity> pedidoItem;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;
}
