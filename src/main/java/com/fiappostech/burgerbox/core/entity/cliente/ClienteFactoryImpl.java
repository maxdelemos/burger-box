package com.fiappostech.burgerbox.core.entity.cliente;

import java.time.LocalDateTime;

public class ClienteFactoryImpl implements ClienteFactory {
    @Override
    public Cliente create(String cpf) {
        return new ClienteImpl(cpf);
    }

    @Override
    public Cliente create(String nome, String cpf) {
        return new ClienteImpl(nome, cpf);
    }

    @Override
    public Cliente create(
            Long id,
            String nome,
            String email,
            LocalDateTime dataAtualizacao,
            LocalDateTime dataCriacao
    ) {
        return new ClienteImpl(id, nome, email, dataAtualizacao, dataCriacao);
    }

    @Override
    public Cliente create(Long id, String nome, String cpf, String email, LocalDateTime dataAtualizacao, LocalDateTime dataCriacao) {
        return new ClienteImpl(id, nome, cpf, email, dataAtualizacao, dataCriacao);
    }

    @Override
    public Cliente create(
            Long id,
            String cpf,
            LocalDateTime dataCriacao,
            LocalDateTime dataAtualizacao
    ) {
        return new ClienteImpl(id, cpf, dataAtualizacao, dataCriacao);
    }
}
