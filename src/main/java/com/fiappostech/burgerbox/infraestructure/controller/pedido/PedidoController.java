package com.fiappostech.burgerbox.infraestructure.controller.pedido;

import com.fiappostech.burgerbox.infraestructure.controller.pedido.request.PedidoRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.response.PedidoResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/pedidos")
public interface PedidoController {
    @PostMapping
    public ResponseEntity<PedidoResponseModel> cadastrar(@RequestBody PedidoRequestModel pedidoRequestModel);

    @GetMapping
    public ResponseEntity<List<Object>> listar(@RequestBody Object o);

    @GetMapping("/{id}/status-pagamento")
    public ResponseEntity<Object> statusPagamento(@PathVariable Object o);

    @PostMapping("/webhooks/pagamento")
    public ResponseEntity<Object> webhooksPagamento(@RequestBody Object o);

    @PutMapping("/{id}/status")
    public ResponseEntity<Object> status(@PathVariable Object o);
}
