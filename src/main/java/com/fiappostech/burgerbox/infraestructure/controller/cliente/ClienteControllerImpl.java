package com.fiappostech.burgerbox.infraestructure.controller.cliente;

import com.fiappostech.burgerbox.core.usecase.cliente.CadastrarClienteBoundary;
import com.fiappostech.burgerbox.core.usecase.cliente.IdentificarClienteBoundary;
import com.fiappostech.burgerbox.infraestructure.controller.cliente.request.ClienteRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.cliente.request.IdentificarRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.cliente.response.ClienteResponseModel;
import com.fiappostech.burgerbox.infraestructure.controller.cliente.response.IdentificarClienteResponseModel;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ClienteControllerImpl implements ClienteController {

    private final CadastrarClienteBoundary cadastrarClienteBoundary;
    private final IdentificarClienteBoundary identificarClienteBoundary;

    @PostMapping
    public ResponseEntity<ClienteResponseModel> cadastrar(@RequestBody ClienteRequestModel clienteResponseModel) {
        return ResponseEntity.ok(cadastrarClienteBoundary.execute(clienteResponseModel));
    }

    @PostMapping("/identificar")
    public ResponseEntity<IdentificarClienteResponseModel> identificar(@RequestBody IdentificarRequestModel identificarClienteRequestModel) {
        return ResponseEntity.ok(identificarClienteBoundary.execute(identificarClienteRequestModel));
    }
}
