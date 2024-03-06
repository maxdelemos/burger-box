package com.fiappostech.burgerbox.core.entity.cliente;

public interface ClienteFactory {
    Cliente create(Long id, String nome, String cpf);
}
