package com.fiappostech.burgerbox.infraestructure.persistence.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusPedidoEnum {
    RECEBIDO("RECEBIDO", "Recebido"),
    EM_PREPARACAO("EM_PREPARACAO", "Em preparação"),
    PRONTO("PRONTO", "Pronto"),
    FINALIZADO("FINALIZADO", "Finalizado");

    private final String codigo;
    private final String descricao;

    public static StatusPedidoEnum buscarPorCodigo(String codigo) {
        for (StatusPedidoEnum e : values()) {
            if (e.getCodigo().equals(codigo)) {
                return e;
            }
        }
        return null;
    }
}
