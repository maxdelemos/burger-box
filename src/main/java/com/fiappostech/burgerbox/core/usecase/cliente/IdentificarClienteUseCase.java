package com.fiappostech.burgerbox.core.usecase.cliente;

import com.fiappostech.burgerbox.core.entity.ClienteDomain;

public interface IdentificarClienteUseCase {
    ClienteDomain execute(ClienteDomain cliente);
}
