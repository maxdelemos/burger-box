package com.fiappostech.burgerbox.infraestructure.controller.cliente.response;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class IdentificarClientePresenterFormatter implements IdentificarClientePresenter {
    @Override
    public IdentificarClienteResponseModel prepareFailView(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }

    @Override
    public IdentificarClienteResponseModel prepareSuccessView(IdentificarClienteResponseModel clienteResponseModel) {
        return clienteResponseModel;
    }
}
