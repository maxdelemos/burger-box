package com.fiappostech.burgerbox.infraestructure.persistence.pedidoItem;

import com.fiappostech.burgerbox.infraestructure.persistence.pedido.PedidoEntity;
import com.fiappostech.burgerbox.infraestructure.persistence.produto.ProdutoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "produto_id", referencedColumnName = "id")
    private ProdutoEntity produto;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;
}