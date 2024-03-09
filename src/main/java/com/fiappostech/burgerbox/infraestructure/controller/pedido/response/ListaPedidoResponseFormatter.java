package com.fiappostech.burgerbox.infraestructure.controller.pedido.response;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ListaPedidoResponseFormatter implements ListaPedidoPresenter {
    @Override
    public List<ListaPedidoResponseModel> prepareSuccessView(List<ListaPedidoResponseModel> produtoResponseModel) {
        return produtoResponseModel.stream().peek(listaPedidoResponseModel -> {
            LocalDateTime responseTime = LocalDateTime.parse(listaPedidoResponseModel.getDataAtualizacao());
            listaPedidoResponseModel.setDataAtualizacao(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        }).toList();
    }

    @Override
    public ListaPedidoResponseModel prepareFailView(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }
}
