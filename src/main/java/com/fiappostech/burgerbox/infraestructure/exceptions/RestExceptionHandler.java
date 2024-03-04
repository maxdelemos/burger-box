package com.fiappostech.burgerbox.infraestructure.exceptions;

import com.fiappostech.burgerbox.core.exceptions.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    private ResponseEntity<String> cpfAlreadyRegistred(BusinessException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Já existe um cliente cadastrado com esse CPF");
    }
}
