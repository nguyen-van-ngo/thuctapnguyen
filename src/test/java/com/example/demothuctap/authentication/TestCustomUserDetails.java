package com.example.demothuctap.authentication;

import com.example.demothuctap.user.User;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCustomUserDetails {
    @Test
    public void testCustomUserDetailsConstructor() {
        User user = new User(1L,"nguyen","123");
        CustomUserDetails customUserDetails = new CustomUserDetails(user);
        assertEquals("nguyen",customUserDetails.getUsername());
        assertEquals("123",customUserDetails.getPassword());
    }
}
