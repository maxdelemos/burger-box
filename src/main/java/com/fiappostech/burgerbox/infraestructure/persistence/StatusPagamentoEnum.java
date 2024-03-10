package com.fiappostech.burgerbox.infraestructure.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusPagamentoEnum {
    APROVADO("APROVADO", "Pagamento foi aprovado"),
    PENDENTE("PENDENTE", "Pagamento está pendente"),
    RECUSADO("RECUSADO", "Pagamento não foi aprovado");

    private final String codigo;
    private final String descricao;

    public static StatusPagamentoEnum buscarPorCodigo(String codigo) {
        for (StatusPagamentoEnum e : values()) {
            if (e.getCodigo().equals(codigo)) {
                return e;
            }
        }
        return null;
    }
}
