package com.fiappostech.burgerbox.infraestructure.controller.produto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoriaResponseModel {
    private Long id;
    private String descricao;
    private String codigo;
}
