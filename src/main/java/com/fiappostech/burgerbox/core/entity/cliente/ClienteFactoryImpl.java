package com.fiappostech.burgerbox.core.entity.cliente;

public class ClienteFactoryImpl implements ClienteFactory {
    @Override
    public Cliente create(Long id, String nome, String cpf) {
        return new ClienteImpl(id, nome, cpf);
    }
}
