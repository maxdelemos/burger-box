package com.fiappostech.burgerbox.infraestructure.controller.cliente.response;

public interface IdentificarClientePresenter {
    IdentificarClienteResponseModel prepareFailView(String error);
    IdentificarClienteResponseModel prepareSuccessView(IdentificarClienteResponseModel clienteResponseModel);

}
