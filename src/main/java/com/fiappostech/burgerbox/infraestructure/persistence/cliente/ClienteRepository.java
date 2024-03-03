package com.fiappostech.burgerbox.infraestructure.persistence.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    ClienteEntity findAllByCpf(String cpf);
}
