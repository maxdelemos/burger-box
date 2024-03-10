package com.fiappostech.burgerbox.core.entity.cliente;

import java.time.LocalDateTime;

public interface ClienteFactory {
    Cliente create(String cpf);
    Cliente create(String nome, String email);
    Cliente create(Long id, String nome, String email, LocalDateTime dataAtualizacao, LocalDateTime dataCriacao);
    Cliente create(Long id, String nome, String cpf, String email, LocalDateTime dataAtualizacao, LocalDateTime dataCriacao);

    Cliente create(Long id, String cpf, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao);
}
