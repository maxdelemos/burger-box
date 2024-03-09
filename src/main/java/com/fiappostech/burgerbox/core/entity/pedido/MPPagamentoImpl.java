package com.fiappostech.burgerbox.core.entity.pedido;

public class MPPagamentoImpl implements MPPagamento {
    private final String qrCodePix;
    private final String codigoPix;

    public MPPagamentoImpl(String qrCodePix, String codigoPix) {
        this.qrCodePix = qrCodePix;
        this.codigoPix = codigoPix;
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
