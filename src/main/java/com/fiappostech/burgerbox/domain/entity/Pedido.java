package com.fiappostech.burgerbox.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "pedido", schema = "public")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @Column(name = "data_criacao")
    private String dataCriacao;

    @Column(name = "data_atualizacao")
    private String dataAtualizacao;
}
