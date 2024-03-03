package com.fiappostech.burgerbox.core.entity;

import java.time.LocalDateTime;

public record ClienteDomain(
        Long id,
        String nome,
        String cpf,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao
) {}
