package com.example.demothuctap.models.response;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestErrorResponse {

    @Test
    void set_getStatus() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.OK);
        assertEquals(HttpStatus.OK,errorResponse.getStatus());
    }

    @Test
    void set_getMsg() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMsg("THANH CONG");
        assertEquals("THANH CONG",errorResponse.getMsg());
    }
    @Test
    void testErrorResponseConstructor() {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.OK,"THANH CONG");
        assertEquals(HttpStatus.OK,errorResponse.getStatus());
        assertEquals("THANH CONG",errorResponse.getMsg());
    }
}