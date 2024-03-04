package com.fiappostech.burgerbox.infraestructure.controller.produto;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produtos")
@AllArgsConstructor
public class ProdutoController {
    @PostMapping
    public ResponseEntity<Object> cadastrar(@RequestBody Object o) {
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editar(@PathVariable Long id, @RequestBody Object o) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> remover(@PathVariable Long id) {
        return ResponseEntity.ok(null);
    }
}
