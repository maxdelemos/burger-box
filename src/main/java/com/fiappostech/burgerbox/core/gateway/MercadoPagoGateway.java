package com.fiappostech.burgerbox.core.gateway;

import com.fiappostech.burgerbox.core.entity.pagamento.Pagamento;

public interface MercadoPagoGateway {
    Pagamento gerarPagamento(Double valor);
    Pagamento consultarPagamento(Long id);
}
