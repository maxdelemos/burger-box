package com.fiappostech.burgerbox.core.usecase.cliente;

import com.fiappostech.burgerbox.infraestructure.controller.cliente.request.ClienteRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.cliente.response.ClienteResponseModel;

public interface CadastrarClienteBoundary {

    ClienteResponseModel execute(ClienteRequestModel clienteResponseModel);
}
