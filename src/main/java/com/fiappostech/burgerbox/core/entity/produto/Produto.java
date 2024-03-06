package com.fiappostech.burgerbox.core.entity.produto;

import java.time.LocalDateTime;
import java.util.List;

public interface Produto {
    Long getId();

    String getNome();

    Double getPreco();

    String getDescricao();

    String getImagem();

    Boolean getAtivo();

    List<Categoria> getCategorias();

    LocalDateTime getDataCriacao();

    LocalDateTime getDataAtualizacao();
}
