package com.fiappostech.burgerbox.infraestructure.persistence.pedido;

import com.fiappostech.burgerbox.infraestructure.persistence.cliente.ClienteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pedido", schema = "public")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    @Column(name = "data_criacao")
    private String dataCriacao;

    @Column(name = "data_atualizacao")
    private String dataAtualizacao;
}
