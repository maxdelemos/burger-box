package com.fiappostech.burgerbox.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "produto", schema = "public")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "valor")
    private double valor;

    @Column(name = "data_criacao")
    private String dataCriacao;

    @Column(name = "data_atualizacao")
    private String dataAtualizacao;
}

