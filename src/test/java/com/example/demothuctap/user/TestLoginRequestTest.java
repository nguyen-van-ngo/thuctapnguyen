package com.example.demothuctap.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLoginRequestTest {

    @Test
    void getUsername() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("nguyen");
        assertEquals("nguyen",loginRequest.getUsername());
    }

    @Test
    void getPassword() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("123");
        assertEquals("123",loginRequest.getPassword());
    }

    @Test
    void setUsername() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("nguyen");
        assertEquals("nguyen",loginRequest.getUsername());
    }

    @Test
    void setPassword() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("123");
        assertEquals("123",loginRequest.getPassword());
    }
    @Test
    void testLoginRequestConstructor() {
        LoginRequest loginRequest = new LoginRequest("nguyen","123");
        assertEquals("nguyen",loginRequest.getUsername());
        assertEquals("123",loginRequest.getPassword());
    }
}
