package com.fiappostech.burgerbox.infraestructure.controller.pedido;

import com.fiappostech.burgerbox.core.usecase.pedido.CadastrarPedidoInteractor;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.request.PedidoRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.response.PedidoResponseModel;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@AllArgsConstructor
public class PedidoControllerImpl implements PedidoController {
    private final CadastrarPedidoInteractor cadastrarPedidoInteractor;

    @PostMapping
    public ResponseEntity<PedidoResponseModel> cadastrar(@RequestBody PedidoRequestModel pedidoRequestModel) {
        return ResponseEntity.ok(cadastrarPedidoInteractor.execute(pedidoRequestModel));
    }

    @GetMapping
    public ResponseEntity<List<Object>> listar(@RequestBody Object o) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{id}/status-pagamento")
    public ResponseEntity<Object> statusPagamento(@PathVariable Object o) {
        return ResponseEntity.ok(null);
    }

    @PostMapping("/webhooks/pagamento")
    public ResponseEntity<Object> webhooksPagamento(@RequestBody Object o) {
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Object> status(@PathVariable Object o) {
        return ResponseEntity.ok(null);
    }
}
