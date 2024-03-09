package com.fiappostech.burgerbox.core.entity.pedido;

public class MPPagamentoFactoryImpl implements MPPagamentoFactory {
    @Override
    public MPPagamento create(String qrcodePix, String codigoPix) {
        return new MPPagamentoImpl(qrcodePix, codigoPix);
    }
}
