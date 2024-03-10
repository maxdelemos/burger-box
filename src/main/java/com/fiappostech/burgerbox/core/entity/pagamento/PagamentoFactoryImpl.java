package com.fiappostech.burgerbox.core.entity.pagamento;

public class PagamentoFactoryImpl implements PagamentoFactory {
    @Override
    public Pagamento create(Long id, String status,String qrcodePix, String codigoPix) {
        return new PagamentoImpl(id, status, qrcodePix, codigoPix);
    }
}
