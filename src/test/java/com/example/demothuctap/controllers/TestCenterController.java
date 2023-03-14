package com.example.demothuctap.controllers;

import com.example.demothuctap.models.dto.CenterDTO;
import com.example.demothuctap.models.entity.Center;
import com.example.demothuctap.models.entity.Fresher;
import com.example.demothuctap.models.response.ResponseObject;
import com.example.demothuctap.service.serviceinterface.CenterService;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TestCenterController {
    @Mock
    CenterService centerService;
    @InjectMocks
    CenterController centerController;
    private Center center;
    private Fresher fresher;
    @BeforeEach
    void setUp(){
        center = new Center();
        center.setCenCode("a1");

        fresher = new Fresher();
        fresher.setFresName("NGUYEN");
        fresher.setFresEmail("nguyenngo@gmail.com");
    }
    @Test
    void getAllCenter() {
        List<Center> centerList = new ArrayList<>();
        centerList.add(mock(Center.class));
        centerList.add(mock(Center.class));

        Mockito.when(centerService.getAllCenter()).thenReturn(centerList);
        ResponseEntity<ResponseObject> response = centerController.getAllCenter();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("OK", response.getBody().getStatus());
        assertEquals("Get all center successfully", response.getBody().getMsg());
    }

    @Test
    void getAllFresherOfCenter() {
        String centerId = "1";
        List<Fresher> fresherList = new ArrayList<>();
        fresherList.add(mock(Fresher.class));
        fresherList.add(mock(Fresher.class));

        when(centerService.getListFresherOfCenter(centerId)).thenReturn(fresherList);
        ResponseEntity<ResponseObject> response = centerController.getAllFresherOfCenter(centerId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Ok", response.getBody().getStatus());
        assertEquals("Get All fresher of center " + centerId, response.getBody().getMsg());

    }

    @Test
    void addCenter() {
        CenterDTO centerDTO = new CenterDTO();
        centerDTO.setCenName("a1");
        centerDTO.setCenCode("a1");
        centerDTO.setCenAddress("CHICHI");
        centerDTO.setCenPhone("0985217059");

        ResponseEntity<ResponseObject> response = centerController.addCenter(centerDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("OK", response.getBody().getStatus());
        assertEquals("Insert center successfully", response.getBody().getMsg());
        verify(centerService, times(1)).addCenter(any(Center.class));

    }

    @Test
    void editCenter() {
        CenterDTO centerDTO = new CenterDTO();
        centerDTO.setCenName("A1");
        centerDTO.setCenCode("a1");
        centerDTO.setCenAddress("MAC");
        centerDTO.setCenPhone("0958217059");

        ResponseEntity<ResponseObject> response = centerController.editCenter(centerDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Ok", response.getBody().getStatus());
        assertEquals("Change or insert fresher successfully", response.getBody().getMsg());
        verify(centerService, times(1)).editCenter(any(Center.class));
    }

    @Test
    void delete() {
        String centerId = "a1";

        ResponseEntity<ResponseObject> response = centerController.delete(centerId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("OK", response.getBody().getStatus());
        assertEquals("Delete fresher successfully", response.getBody().getMsg());
        assertEquals("", response.getBody().getData());
        verify(centerService, times(1)).deleteCenter(centerId);
    }
}