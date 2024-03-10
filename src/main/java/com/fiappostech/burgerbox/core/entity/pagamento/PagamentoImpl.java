package com.fiappostech.burgerbox.core.entity.pagamento;

import java.util.Objects;

public class PagamentoImpl implements Pagamento {
    private final Long id;
    private final String status;
    private final String qrCodePix;
    private final String codigoPix;

    public PagamentoImpl(Long id, String status, String qrCodePix, String codigoPix) {
        this.id = id;
        this.status = Objects.equals(status, "approved") ? "APROVADO" : "PENDENTE";
        this.qrCodePix = qrCodePix;
        this.codigoPix = codigoPix;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public String getStatus() {
        return this.status;
    }

    @Override
    public String getQrcodePix() {
        return this.qrCodePix;
    }

    @Override
    public String getCodigoPix() {
        return this.codigoPix;
    }
}
