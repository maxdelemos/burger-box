package com.fiappostech.burgerbox.infraestructure.controller.produto.request;

import com.fiappostech.burgerbox.infraestructure.controller.produto.response.CategoriaResponseModel;
import lombok.Data;

import java.util.List;

@Data
public class ProdutoRequestModel {
    private String nome;
    private List<CategoriaResponseModel> categorias;
    private double preco;
}
