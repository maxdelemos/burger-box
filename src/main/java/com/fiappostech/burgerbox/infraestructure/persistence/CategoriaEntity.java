package com.fiappostech.burgerbox.infraestructure.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Table(name = "categoria", schema = "public")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "codigo")
    private String codigo;
}
