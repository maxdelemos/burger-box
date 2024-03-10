package com.fiappostech.burgerbox.infraestructure.gateway;

import com.fiappostech.burgerbox.core.entity.pagamento.PagamentoFactory;
import com.fiappostech.burgerbox.core.entity.pagamento.PagamentoFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MercadoPagoGatewayImplTest {

    private MercadoPagoGatewayImpl mercadoPagoGateway;
    private PagamentoFactory mpPagamentoFactory;

    @BeforeEach
    void setUp() {
        mpPagamentoFactory = new PagamentoFactoryImpl();
        mercadoPagoGateway = new MercadoPagoGatewayImpl(mpPagamentoFactory);
    }

    @Test
    public void testCriarPagamentoPIX() throws Exception {
        mercadoPagoGateway.gerarPagamento(0.01);
    }

}