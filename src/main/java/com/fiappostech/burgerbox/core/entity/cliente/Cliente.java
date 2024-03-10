package com.fiappostech.burgerbox.core.entity.cliente;

import java.time.LocalDateTime;

public interface Cliente {
   Long getId();
   String getNome();
   String getCpf();
   String getEmail();
   LocalDateTime getDataCriacao();
   LocalDateTime getDataAtualizacao();
}
