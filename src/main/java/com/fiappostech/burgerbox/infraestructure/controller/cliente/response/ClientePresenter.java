package com.fiappostech.burgerbox.infraestructure.controller.cliente.response;

public interface ClientePresenter {
    ClienteResponseModel prepareFailView(String error);

    ClienteResponseModel prepareSuccessView(ClienteResponseModel clienteResponseModel);
}
