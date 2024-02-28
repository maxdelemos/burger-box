package com.fiappostech.chopphour.adapter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public interface PedidoController {
    @GetMapping(value = "/cadastrar")
    ResponseEntity<String> cadastrar();
}
