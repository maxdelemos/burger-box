package com.fiappostech.burgerbox.infraestructure.configuration;

// Possibilita que o Spring consiga gerenciar os usecases.

import com.fiappostech.burgerbox.core.gateways.clientegateway.ClienteGateway;
import com.fiappostech.burgerbox.core.usecase.cliente.cadastrar.CriarClienteUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public CriarClienteUseCaseImpl criarPessoaUseCase(ClienteGateway clienteGateway) {
        return new CriarClienteUseCaseImpl(clienteGateway);
    }
}
