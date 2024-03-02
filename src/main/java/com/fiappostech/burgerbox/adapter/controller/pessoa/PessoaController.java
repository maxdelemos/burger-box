package com.fiappostech.burgerbox.adapter.controller.pessoa;

import com.fiappostech.burgerbox.domain.usecase.pessoa.cadastrar.CadastrarPessoaInput;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/pessoa")
public interface PessoaController {

    @PostMapping
    ResponseEntity<Object> cadastrar(@RequestBody CadastrarPessoaInput pessoaInput);
}
