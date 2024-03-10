package com.fiappostech.burgerbox.infraestructure.persistence;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Table(name = "cliente", schema = "public")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @CPF(message = "Informar um CPF válido")
    @Column(name = "cpf")
    private String cpf;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;
}
