package com.fiappostech.burgerbox.infraestructure.controller.cliente.response;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ClientePresenterFormatter implements ClientePresenter {
    @Override
    public ClienteResponseModel prepareFailView(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }

    @Override
    public ClienteResponseModel prepareSuccessView(ClienteResponseModel clienteResponseModel) {
        return clienteResponseModel;
    }
}
