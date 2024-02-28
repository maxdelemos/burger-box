package com.fiappostech.chopphour.adapter.controller;

import com.fiappostech.chopphour.domain.usecase.pedido.cadastrar.CadastrarPedidoUsecase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class PedidoControllerImpl implements PedidoController {

    private final CadastrarPedidoUsecase cadastrarPedidoUsecase;

    @Override
    public ResponseEntity<String> cadastrar() {
        return ResponseEntity.ok(cadastrarPedidoUsecase.executar());
    }
}
