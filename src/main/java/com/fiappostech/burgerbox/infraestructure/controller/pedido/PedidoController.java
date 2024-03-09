package com.fiappostech.burgerbox.infraestructure.controller.pedido;

import com.fiappostech.burgerbox.core.entity.pedido.MPPagamentoWebhook;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.request.AtualizarStatusPedidoRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.request.PedidoRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.response.ListaPedidoResponseModel;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.response.PedidoResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/pedidos")
public interface PedidoController {
    @PostMapping
    ResponseEntity<PedidoResponseModel> cadastrar(@RequestBody PedidoRequestModel pedidoRequestModel);

    @GetMapping
    ResponseEntity<List<ListaPedidoResponseModel>> listar();

    @GetMapping("/{id}/status-pagamento")
    ResponseEntity<Object> statusPagamento(@PathVariable Object o);

    @PostMapping("/webhooks/pagamento")
    void webhooksPagamento(@RequestBody MPPagamentoWebhook mpPagamentoWebhook);

    @PutMapping("/{id}/status")
    ResponseEntity<Object> status(@PathVariable Long id, @RequestBody AtualizarStatusPedidoRequestModel atualizarStatusPedidoRequestModel);
}
