package com.fiappostech.burgerbox.adapter.controller.cliente;

import com.fiappostech.burgerbox.domain.usecase.cliente.cadastrar.CadastrarClienteInput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cliente")
public interface ClienteController {

    @PostMapping
    ResponseEntity<Object> cadastrar(@RequestBody CadastrarClienteInput clienteInput);
}
