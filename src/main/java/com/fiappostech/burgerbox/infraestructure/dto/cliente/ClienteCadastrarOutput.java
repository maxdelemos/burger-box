package com.fiappostech.burgerbox.infraestructure.dto.cliente;

import java.time.LocalDateTime;

public record ClienteCadastrarOutput(
        String nome,
        String cpf,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao
) {
}
