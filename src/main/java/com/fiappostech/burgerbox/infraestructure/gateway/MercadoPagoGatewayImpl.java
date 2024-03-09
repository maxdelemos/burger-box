package com.fiappostech.burgerbox.infraestructure.gateway;

import com.fiappostech.burgerbox.core.entity.pedido.MPPagamento;
import com.fiappostech.burgerbox.core.entity.pedido.MPPagamentoFactory;
import com.fiappostech.burgerbox.core.gateway.MercadoPagoGateway;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Random;

@Component
public class MercadoPagoGatewayImpl implements MercadoPagoGateway {
    private final MPPagamentoFactory mpPagamentoFactory;

    public MercadoPagoGatewayImpl(MPPagamentoFactory mpPagamentoFactory) {
        this.mpPagamentoFactory = mpPagamentoFactory;
    }

    public MPPagamento gerarPagamento(Double valor) {
        Double numeroAleatorio = 0.01 + new Random().nextDouble() * 0.02;
        numeroAleatorio = Math.floor(numeroAleatorio * 100) / 100;
        PaymentClient client = new PaymentClient();
        PaymentCreateRequest createRequest =
                PaymentCreateRequest.builder()
                        .transactionAmount(new BigDecimal(valor+numeroAleatorio))
                        .description("description")
                        .installments(1)
                        .paymentMethodId("pix")
                        .payer(PaymentPayerRequest.builder().email("maxmilian.lemos@gmail.com").build())
                        .build();
        try {
            Payment payment = client.create(createRequest);
            return mpPagamentoFactory.create(
                    payment.getPointOfInteraction().getTransactionData().getQrCodeBase64(),
                    payment.getPointOfInteraction().getTransactionData().getQrCode()
            );
        } catch (MPApiException ex) {
            System.out.printf(
                    "MercadoPago Error. Status: %s, Content: %s%n",
                    ex.getApiResponse().getStatusCode(), ex.getApiResponse().getContent());
        } catch (MPException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Object consultarPagamento(Long paymentId) {
        try {
            PaymentClient client = new PaymentClient();
            Payment payment = client.get(paymentId);
            return payment;
        } catch (MPApiException ex) {
            System.out.printf(
                    "MercadoPago Error. Status: %s, Content: %s%n",
                    ex.getApiResponse().getStatusCode(), ex.getApiResponse().getContent());
        } catch (MPException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
