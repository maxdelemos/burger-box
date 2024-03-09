package com.fiappostech.burgerbox.infraestructure.gateway;

import com.fiappostech.burgerbox.core.entity.pedido.MPPagamentoFactory;
import com.fiappostech.burgerbox.core.entity.pedido.MPPagamentoFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MercadoPagoGatewayImplTest {

    private MercadoPagoGatewayImpl mercadoPagoGateway;
    private MPPagamentoFactory mpPagamentoFactory;

    @BeforeEach
    void setUp() {
        mpPagamentoFactory = new MPPagamentoFactoryImpl();
        mercadoPagoGateway = new MercadoPagoGatewayImpl(mpPagamentoFactory);
    }

    @Test
    public void testCriarPagamentoPIX() throws Exception {
        mercadoPagoGateway.gerarPagamento(0.01);
    }

}