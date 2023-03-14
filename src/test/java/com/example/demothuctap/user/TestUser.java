package com.example.demothuctap.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUser {

    @Test
    void getId() {
        User user = new User();
        user.setId(1234L);
        assertEquals(1234L,user.getId());
    }

    @Test
    void getUsername() {
        User user = new User();
        user.setUsername("nguyen");
        assertEquals("nguyen",user.getUsername());
    }

    @Test
    void getPassword() {
        User user = new User();
        user.setPassword("123");
        assertEquals("123",user.getPassword());
    }

    @Test
    void setId() {
        User user = new User();
        user.setId(1234L);
        assertEquals(1234L,user.getId());
    }

    @Test
    void setUsername() {
        User user = new User();
        user.setUsername("nguyen");
        assertEquals("nguyen",user.getUsername());
    }

    @Test
    void setPassword() {
        User user = new User();
        user.setPassword("123");
        assertEquals("123",user.getPassword());
    }
    @Test
    void testUserConstructor(){
        User user = new User(1234L,"nguyen","123");
        assertEquals(1234L,user.getId());
        assertEquals("nguyen",user.getUsername());
        assertEquals("123",user.getPassword());
    }

}
