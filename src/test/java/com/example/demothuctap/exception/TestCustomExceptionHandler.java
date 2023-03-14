package com.example.demothuctap.exception;

import com.example.demothuctap.models.response.ErrorResponse;
import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestCustomExceptionHandler {

    @Test
    void handlerNotImplementedException() {
        ExecutionControl.NotImplementedException ex = new ExecutionControl.NotImplementedException("NotImplementedException");
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_IMPLEMENTED, ex.getMessage());
        CustomExceptionHandler customExceptionHandler = new CustomExceptionHandler();
        ErrorResponse result = customExceptionHandler.handlerNotImplementedException(ex);
        assertEquals(response.getStatus(), result.getStatus());
        assertEquals(response.getMsg(), result.getMsg());
    }

    @Test
    void handlerNotFoundException() {
        NotFoundException ex = new NotFoundException("NotFoundException");
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
        CustomExceptionHandler customExceptionHandler = new CustomExceptionHandler();
        ErrorResponse result = customExceptionHandler.handlerNotFoundException(ex);
        assertEquals(response.getStatus(), result.getStatus());
        assertEquals(response.getMsg(), result.getMsg());
    }
}