package com.example.demothuctap.service.implement;

import com.example.demothuctap.authentication.CustomUserDetails;
import com.example.demothuctap.respositories.UserRepository;
import com.example.demothuctap.user.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestUserServiceIplm {
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserServiceImpl userService;

    @Test
    void loadUserByUsername() {
        String username = "nguyen";
        User user = new User();
        user.setUsername(username);
        user.setPassword("123");
        when(userRepository.findByUsername(username)).thenReturn(user);
        CustomUserDetails userDetails = (CustomUserDetails) userService.loadUserByUsername(username);
        assertNotNull(userDetails);
        assertEquals(username, userDetails.getUsername());
        assertEquals(user.getPassword(), userDetails.getPassword());
        assertTrue(userDetails.isEnabled());
        assertTrue(userDetails.isAccountNonExpired());
        assertTrue(userDetails.isAccountNonLocked());
        assertTrue(userDetails.isCredentialsNonExpired());
    }

    @Test
    void loadUserByUsernameNotFound() {
        String username = "nguyen";
        when(userRepository.findByUsername(username)).thenReturn(null);

        UsernameNotFoundException exception = assertThrows(UsernameNotFoundException.class, () -> {
            userService.loadUserByUsername(username);
        });
        assertEquals("User not found with username : " + username, exception.getMessage());
    }
    @Test
    void loadUserById() {
        Long id = 1L;
        User user = new User();
        user.setId(id);
        user.setUsername("nguyen");
        user.setPassword("123");
        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        CustomUserDetails userDetails = (CustomUserDetails) userService.loadUserById(id);
        assertNotNull(userDetails);
        assertEquals(user.getUsername(), userDetails.getUsername());
        assertEquals(user.getPassword(), userDetails.getPassword());
        assertTrue(userDetails.isEnabled());
        assertTrue(userDetails.isAccountNonExpired());
        assertTrue(userDetails.isAccountNonLocked());
        assertTrue(userDetails.isCredentialsNonExpired());
    }

    @Test
    void loadUserByIdNotFound() {
        Long id = 1L;
        when(userRepository.findById(id)).thenReturn(Optional.empty());

        UsernameNotFoundException exception = assertThrows(UsernameNotFoundException.class, () -> {
            userService.loadUserById(id);
        });
        assertEquals("User not found with id : " + id, exception.getMessage());
    }
}
