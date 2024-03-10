package com.fiappostech.burgerbox.core.usecase.cliente;

import com.fiappostech.burgerbox.infraestructure.controller.cliente.request.IdentificarRequestModel;
import com.fiappostech.burgerbox.infraestructure.controller.cliente.response.IdentificarClienteResponseModel;

public interface IdentificarClienteBoundary {
    IdentificarClienteResponseModel execute(IdentificarRequestModel identificarRequestModel);
}
