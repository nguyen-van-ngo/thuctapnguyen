package com.example.demothuctap.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLoginResponse {

    @Test
    void getAccessToken() {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setAccessToken("Day La accessToken");
        assertEquals("Day La accessToken",loginResponse.getAccessToken());

    }

    @Test
    void getTokenType() {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setTokenType("Bearer");
        assertEquals("Bearer",loginResponse.getTokenType());
    }

    @Test
    void setAccessToken() {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setAccessToken("Day La accessToken");
        assertEquals("Day La accessToken",loginResponse.getAccessToken());
    }

    @Test
    void setTokenType() {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setTokenType("Bearer");
        assertEquals("Bearer",loginResponse.getTokenType());
    }
    @Test
    void testLoginResponseConstructor() {
        LoginResponse loginResponse = new LoginResponse("Day la token");
        assertEquals("Day la token",loginResponse.getAccessToken());
    }
}
