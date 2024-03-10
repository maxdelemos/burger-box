package com.fiappostech.burgerbox.infraestructure.gateway;

import com.fiappostech.burgerbox.core.entity.cliente.Cliente;
import com.fiappostech.burgerbox.core.entity.cliente.ClienteFactory;
import com.fiappostech.burgerbox.core.gateway.ClienteGateway;
import com.fiappostech.burgerbox.infraestructure.persistence.ClienteEntity;
import com.fiappostech.burgerbox.infraestructure.persistence.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClienteGatewayImpl implements ClienteGateway {

    private final ClienteRepository clienteRepository;
    private final ClienteFactory clienteFactory;

    @Override
    public Cliente cadastrar(Cliente cliente) {
        ClienteEntity novaPessoa = clienteRepository.save(
                ClienteEntity
                        .builder()
                        .nome(cliente.getNome())
                        .email(cliente.getEmail())
                        .dataCriacao(LocalDateTime.now())
                        .dataAtualizacao(LocalDateTime.now())
                        .build()
        );

        ClienteEntity pessoaCadastrada = clienteRepository.saveAndFlush(novaPessoa);

        return clienteFactory.create(
                pessoaCadastrada.getId(),
                pessoaCadastrada.getNome(),
                pessoaCadastrada.getEmail(),
                pessoaCadastrada.getDataCriacao(),
                pessoaCadastrada.getDataAtualizacao()
        );
    }

    @Override
    public Cliente buscarPorEmail(String email) {
        ClienteEntity clienteEntity = clienteRepository.findAllByEmail(email);
        if (clienteEntity == null) {
            return null;
        }
        return clienteFactory.create(
                clienteEntity.getId(),
                clienteEntity.getNome(),
                clienteEntity.getCpf(),
                clienteEntity.getEmail(),
                clienteEntity.getDataCriacao(),
                clienteEntity.getDataAtualizacao()
        );
    }

    @Override
    public Cliente buscarPorCpf(String cpf) {
        ClienteEntity clienteEntity = clienteRepository.findAllByCpf(cpf);
        if (clienteEntity == null) {
            return null;
        }
        return clienteFactory.create(
                clienteEntity.getId(),
                clienteEntity.getNome(),
                clienteEntity.getCpf(),
                clienteEntity.getDataCriacao(),
                clienteEntity.getDataAtualizacao()
        );
    }

    @Override
    public Cliente identificar(Cliente cliente) {
        ClienteEntity novaPessoa = clienteRepository.save(
                ClienteEntity
                        .builder()
                        .cpf(cliente.getCpf())
                        .dataCriacao(LocalDateTime.now())
                        .dataAtualizacao(LocalDateTime.now())
                        .build()
        );

        ClienteEntity pessoaCadastrada = clienteRepository.saveAndFlush(novaPessoa);

        return clienteFactory.create(
                pessoaCadastrada.getId(),
                pessoaCadastrada.getCpf(),
                pessoaCadastrada.getDataCriacao(),
                pessoaCadastrada.getDataAtualizacao()
        );
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<ClienteEntity> clienteEntity = clienteRepository.findById(id);
        return clienteEntity.map(cliente -> clienteFactory.create(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getDataCriacao(),
                cliente.getDataAtualizacao()
        )).orElse(null);
    }
}
