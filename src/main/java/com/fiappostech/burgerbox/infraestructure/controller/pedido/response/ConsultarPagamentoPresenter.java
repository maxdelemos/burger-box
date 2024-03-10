package com.fiappostech.burgerbox.infraestructure.controller.pedido.response;

public interface ConsultarPagamentoPresenter {
    ConsultarPagamentoResponseModel prepareFailView(String error);
    ConsultarPagamentoResponseModel prepareSuccessView(ConsultarPagamentoResponseModel consultarPagamentoResponseModel);
}
