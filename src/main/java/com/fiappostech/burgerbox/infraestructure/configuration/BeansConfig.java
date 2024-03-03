package com.fiappostech.burgerbox.infraestructure.configuration;

// Possibilita que o Spring consiga gerenciar os usecases.

import com.fiappostech.burgerbox.core.entity.ClienteDomain;
import com.fiappostech.burgerbox.core.gateway.cliente.ClienteGateway;
import com.fiappostech.burgerbox.core.usecase.cliente.CadastrarClienteUseCaseImpl;
import com.fiappostech.burgerbox.core.usecase.cliente.IdentificarClienteUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public CadastrarClienteUseCaseImpl criarPessoaUseCase(ClienteGateway clienteGateway) {
        return new CadastrarClienteUseCaseImpl(clienteGateway);
    }

    @Bean
    public IdentificarClienteUseCaseImpl identificar(ClienteGateway clienteGateway) {
        return new IdentificarClienteUseCaseImpl(clienteGateway);
    }
}
