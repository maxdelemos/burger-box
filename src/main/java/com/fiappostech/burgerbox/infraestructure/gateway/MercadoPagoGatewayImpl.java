package com.fiappostech.burgerbox.infraestructure.gateway;

import com.fiappostech.burgerbox.core.entity.pagamento.Pagamento;
import com.fiappostech.burgerbox.core.entity.pagamento.PagamentoFactory;
import com.fiappostech.burgerbox.core.gateway.MercadoPagoGateway;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Random;

@Component
@Slf4j
public class MercadoPagoGatewayImpl implements MercadoPagoGateway {
    private final PagamentoFactory mpPagamentoFactory;

    public MercadoPagoGatewayImpl(PagamentoFactory mpPagamentoFactory) {
        this.mpPagamentoFactory = mpPagamentoFactory;
    }

    public Pagamento gerarPagamento(Double valor) {
        Double numeroAleatorio = 0.01 + new Random().nextDouble() * 0.02;
        numeroAleatorio = Math.floor(numeroAleatorio * 100) / 100;
        PaymentClient client = new PaymentClient();
        PaymentCreateRequest createRequest =
                PaymentCreateRequest.builder()
                        .transactionAmount(new BigDecimal(valor + numeroAleatorio))
                        .description("Venda no BurgerBox")
                        .installments(1)
                        .paymentMethodId("pix")
                        .payer(PaymentPayerRequest.builder().email("maxmilian.lemos@gmail.com").build())
                        .build();
        try {
            Payment payment = client.create(createRequest);
            return mpPagamentoFactory.create(
                    payment.getId(),
                    payment.getStatus(),
                    payment.getPointOfInteraction().getTransactionData().getQrCodeBase64(),
                    payment.getPointOfInteraction().getTransactionData().getQrCode()
            );
        } catch (MPApiException ex) {
            log.error(
                    "MercadoPago Error. Status: {}, Content: {}%n",
                    ex.getApiResponse().getStatusCode(),
                    ex.getApiResponse().getContent()
            );
        } catch (MPException ex) {
            log.error("MercadoPago Error.", ex);
        }
        return null;
    }

    @Override
    public Pagamento consultarPagamento(Long paymentId) {
        try {
            PaymentClient client = new PaymentClient();
            Payment payment = client.get(paymentId);
            return mpPagamentoFactory.create(
                    payment.getId(),
                    payment.getStatus(),
                    payment.getPointOfInteraction().getTransactionData().getQrCodeBase64(),
                    payment.getPointOfInteraction().getTransactionData().getQrCode()
            );
        } catch (MPApiException ex) {
            log.error(
                    "MercadoPago Error. Status: {}, Content: {}%n",
                    ex.getApiResponse().getStatusCode(),
                    ex.getApiResponse().getContent()
            );
        } catch (MPException ex) {
            log.error("MercadoPago Error.", ex);
        }
        return null;
    }
}
