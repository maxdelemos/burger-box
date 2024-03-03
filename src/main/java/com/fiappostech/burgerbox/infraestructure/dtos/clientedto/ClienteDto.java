package com.fiappostech.burgerbox.infraestructure.dtos.clientedto;

import java.time.LocalDateTime;

public record ClienteDto(
        String nome,
        String cpf,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao
) {}
