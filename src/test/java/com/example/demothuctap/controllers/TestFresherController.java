package com.example.demothuctap.controllers;

import com.example.demothuctap.models.dto.FresherDTO;
import com.example.demothuctap.models.entity.Center;
import com.example.demothuctap.models.entity.Fresher;
import com.example.demothuctap.models.response.ResponseObject;
import com.example.demothuctap.service.serviceinterface.FresherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestFresherController {
    @Mock
    FresherService fresherService;
    @InjectMocks
    FresherController fresherController;
    private Center center;
    private Fresher fresher;
    @BeforeEach
    void setUp() {
        fresher = new Fresher();
        fresher.setFresID("a1");
        fresher.setFresEmail("nguyenngo@gmail.com");
    }

    @Test
    void getAll() {
        List<Fresher> fresherList = new ArrayList<>();
        fresherList.add(mock(Fresher.class));
        fresherList.add(mock(Fresher.class));

        Mockito.when(fresherService.getAllFresher()).thenReturn(fresherList);
        ResponseEntity<ResponseObject> response = fresherController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("OK", response.getBody().getStatus());
        assertEquals("Get all fresher successfully", response.getBody().getMsg());

    }

    @Test
    void addFresher() {
        FresherDTO fresherDTO = new FresherDTO();
        fresherDTO.setFresID("1");
        fresherDTO.setFresName("name1");
        fresherDTO.setFresAddress("address1");
        fresherDTO.setFresEmail("email1");
        fresherDTO.setFresPhone("123");

        ResponseEntity<ResponseObject> response = fresherController.addFresher(fresherDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("OK", response.getBody().getStatus());
        assertEquals("Insert fresher successfully", response.getBody().getMsg());
        verify(fresherService, times(1)).addFresher(any(Fresher.class));
    }

    @Test
    void editFresher() {
        FresherDTO fresherDTO = new FresherDTO();
        fresherDTO.setFresID("1");
        fresherDTO.setFresEmail("name1");
        fresherDTO.setFresAddress("address1");
        fresherDTO.setFresEmail("email1");
        fresherDTO.setFresPhone("123");

        ResponseEntity<ResponseObject> response = fresherController.editFresher(fresherDTO);

        assertEquals(HttpStatus.OK,response.getStatusCode());assertNotNull(response.getBody());
        assertEquals("Ok", response.getBody().getStatus());
        assertEquals("Change or insert fresher successfully", response.getBody().getMsg());
        verify(fresherService, times(1)).editFresher(any(Fresher.class));
    }

    @Test
    void delete() {
        String fresherId = "valid_id";

        ResponseEntity<ResponseObject> response = fresherController.delete(fresherId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("OK", response.getBody().getStatus());
        assertEquals("Delete fresher successfully", response.getBody().getMsg());
        assertEquals("", response.getBody().getData());
        verify(fresherService, times(1)).deleteFresher(fresherId);
    }

    @Test
    void searchFresherWithFresherName() {
        String fresherName = "name1";
        List<Fresher> searchResults = Collections.singletonList(new Fresher());
        when(fresherService.searchFresherWithfresName(fresherName)).thenReturn(searchResults);

        ResponseEntity<ResponseObject> response = fresherController.searchFresherWithfresName(fresherName);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("OK", response.getBody().getStatus());
        assertEquals("Search Fresher with fresher name successfully", response.getBody().getMsg());
        verify(fresherService).searchFresherWithfresName(fresherName);
    }

    @Test
    void searchFresherWithFresherEmail() {

    }

    @Test
    void searchFresherWithlanguage() {
        String language = "language1";
        List<Fresher> searchResults = Collections.singletonList(new Fresher());
        when(fresherService.searchFresherWithlanguage(language)).thenReturn(searchResults);

        ResponseEntity<ResponseObject> response = fresherController.searchFresherWithlanguage(language);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("OK", response.getBody().getStatus());
        assertEquals("Search Fresher with language programming successfully", response.getBody().getMsg());
        verify(fresherService).searchFresherWithlanguage(language);
    }
    
}
