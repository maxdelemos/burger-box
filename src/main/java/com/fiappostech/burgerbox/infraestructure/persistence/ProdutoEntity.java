package com.fiappostech.burgerbox.infraestructure.persistence;

import com.fiappostech.burgerbox.infraestructure.persistence.CategoriaEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@ToString
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produto", schema = "public")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @ManyToMany
    @JoinTable(schema = "public", name = "produto_categoria",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<CategoriaEntity> categorias;

    @Column(name = "preco")
    private Double preco;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "imagem")
    private String imagem;

    @Column(name = "ativo")
    private Boolean ativo;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;
}

