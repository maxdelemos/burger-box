package com.fiappostech.burgerbox.infraestructure.controller.produto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProdutoResponseModel {
    private Long id;
    private String nome;
    private List<CategoriaResponseModel> categorias;
    private double preco;
}
