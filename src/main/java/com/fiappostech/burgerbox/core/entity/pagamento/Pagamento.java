package com.fiappostech.burgerbox.core.entity.pagamento;

public interface Pagamento {
    Long getId();
    String getStatus();
    String getQrcodePix();
    String getCodigoPix();
}
