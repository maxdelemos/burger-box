package com.fiappostech.burgerbox.infraestructure.controller.pedido.response;

public class PedidoResponseModel {
    private Long id;
    private String qrCodePix;
    private String codigoPix;

    public PedidoResponseModel(Long id, String qrCodePix, String codigoPix) {
        this.id = id;
        this.qrCodePix = qrCodePix;
        this.codigoPix = codigoPix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoPix() {
        return codigoPix;
    }

    public void setCodigoPix(String codigoPix) {
        this.codigoPix = codigoPix;
    }

    public String getQrCodePix() {
        return qrCodePix;
    }

    public void setQrCodePix(String qrCodePix) {
        this.qrCodePix = qrCodePix;
    }
}
