package com.fiappostech.burgerbox.infraestructure.controller.pedido;

import com.fiappostech.burgerbox.core.entity.pagamento.PagamentoWebhook;
import com.fiappostech.burgerbox.core.usecase.pedido.*;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.request.AtualizarStatusPedidoRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.request.PedidoRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.response.ListaPedidoResponseModel;
import com.fiappostech.burgerbox.infraestructure.controller.pedido.response.PedidoResponseModel;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PedidoControllerImpl implements PedidoController {
    private final CadastrarPedidoBoundary cadastrarPedidoBoundary;
    private final AtualizarPedidoBoundary atualizarPedidoBoundary;
    private final ListarPedidoBoundary listarPedidoBoundary;
    private final WebhookPagamentoBoundary webhookPagamentoBoundary;
    private final ConsultarPagamentoPedidoInteractor consultarPagamentoPedidoInteractor;

    @PostMapping
    public ResponseEntity<PedidoResponseModel> cadastrar(@RequestBody PedidoRequestModel pedidoRequestModel) {
        return ResponseEntity.ok(cadastrarPedidoBoundary.execute(pedidoRequestModel));
    }

    @GetMapping
    public ResponseEntity<List<ListaPedidoResponseModel>> listar() {
        return ResponseEntity.ok(listarPedidoBoundary.execute());
    }

    @GetMapping("/{id}/status-pagamento")
    public ResponseEntity<Object> statusPagamento(@PathVariable Long id) {
        return ResponseEntity.ok(consultarPagamentoPedidoInteractor.execute(id));
    }

    @PostMapping("/webhooks/pagamento")
    public void webhooksPagamento(@RequestBody PagamentoWebhook mpPagamentoWebhook) {
        webhookPagamentoBoundary.execute(mpPagamentoWebhook);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Object> status(@PathVariable Long id, @RequestBody AtualizarStatusPedidoRequestModel atualizarStatusPedidoRequestModel) {
        return ResponseEntity.ok(atualizarPedidoBoundary.execute(id, atualizarStatusPedidoRequestModel));
    }
}
