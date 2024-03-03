package com.fiappostech.burgerbox.core.usecase.pedido;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class CadastrarPedidoUsecase {

    public String executar() {
        return "Pedido cadastrado com sucesso!";
    }
}
