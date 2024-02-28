package com.fiappostech.chopphour.domain.usecase.pedido.cadastrar;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class CadastrarPedidoUsecase {

    public String executar() {
        return "Pedido cadastrado com sucesso!";
    }
}
