package com.fiappostech.burgerbox.core.entity.pedido;

public interface MPPagamentoFactory {
    MPPagamento create(String qrcodePix, String codigoPix);
}
