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
@Table(name = "pedido_item", schema = "public")
public class PedidoItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private PedidoEntity pedido;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "produto_id", referencedColumnName = "id")
    private ProdutoEntity produto;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;
}