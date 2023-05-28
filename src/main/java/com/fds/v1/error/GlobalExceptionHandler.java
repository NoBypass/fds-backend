package com.fds.v1.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public DefaultErrorResponse handleResourceNotFoundException(NotFoundException ex) {
        return new DefaultErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public DefaultErrorResponse handleRuntimeException(RuntimeException ex) {
        return new DefaultErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
    }
}
