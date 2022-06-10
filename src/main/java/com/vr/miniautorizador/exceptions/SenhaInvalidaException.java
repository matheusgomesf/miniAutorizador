package com.vr.miniautorizador.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "SENHA_INVALIDA")
public class SenhaInvalidaException extends RuntimeException {
}
