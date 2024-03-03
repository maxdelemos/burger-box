package com.fiappostech.burgerbox.infraestructure.dto.cliente;

import java.time.LocalDateTime;

public record ClienteCadastrarInput(
        String nome,
        String cpf
) {}
