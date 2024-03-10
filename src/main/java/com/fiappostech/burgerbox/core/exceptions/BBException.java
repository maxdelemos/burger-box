package com.fiappostech.burgerbox.core.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class BBException extends ResponseStatusException {
    public BBException(HttpStatusCode status, String reason) {
        super(status, reason);
    }
}
