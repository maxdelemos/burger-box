package com.fiappostech.burgerbox.core.entity.pagamento;

public interface PagamentoFactory {
    Pagamento create(Long id, String status,String qrcodePix, String codigoPix);
}
