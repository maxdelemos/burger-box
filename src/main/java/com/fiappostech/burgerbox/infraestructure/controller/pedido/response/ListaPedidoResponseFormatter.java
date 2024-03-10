package com.fiappostech.burgerbox.infraestructure.controller.pedido.response;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ListaPedidoResponseFormatter implements ListaPedidoPresenter {
    @Override
    public ListaPedidoResponseModel prepareFailView(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }

    @Override
    public List<ListaPedidoResponseModel> prepareSuccessView(List<ListaPedidoResponseModel> produtoResponseModel) {
        List<ListaPedidoResponseModel> list = new ArrayList<>();
        for (ListaPedidoResponseModel listaPedidoResponseModel : produtoResponseModel) {
            LocalDateTime responseTime = LocalDateTime.parse(listaPedidoResponseModel.getDataAtualizacao());
            listaPedidoResponseModel.setDataAtualizacao(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
            list.add(listaPedidoResponseModel);
        }
        return list;
    }
}
