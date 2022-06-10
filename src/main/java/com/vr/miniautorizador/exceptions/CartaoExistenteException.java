package com.vr.miniautorizador.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class CartaoExistenteException extends RuntimeException {

    public CartaoExistenteException(String message) {
        super(message);
    }
}
