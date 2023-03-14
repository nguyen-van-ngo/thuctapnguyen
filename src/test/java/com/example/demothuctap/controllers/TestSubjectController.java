package com.example.demothuctap.controllers;

import com.example.demothuctap.models.dto.SubjectDTO;
import com.example.demothuctap.models.entity.Subject;
import com.example.demothuctap.models.response.ResponseObject;
import com.example.demothuctap.service.serviceinterface.SubjectService;
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
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class TestSubjectController {
    @Mock
    SubjectService subjectService;
    @InjectMocks
    SubjectController subjectController;
    private Subject subject;
    @BeforeEach
    void setUp() {
        subject = new Subject();
        subject.setSubId("a1");
    }

    @Test
    void addSubject() {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setSubId("1");
        subjectDTO.setLanguage("PYTHON");

        ResponseEntity<ResponseObject> response = subjectController.addSub(subjectDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("OK", response.getBody().getStatus());
        assertEquals("Insert fresher successfully", response.getBody().getMsg());
        verify(subjectService, times(1)).addSub(any(Subject.class));
    }

    @Test
    void getAllSubject() {
        List<Subject> subjectList = new ArrayList<>();
        subjectList.add(mock(Subject.class));
        subjectList.add(mock(Subject.class));

        Mockito.when(subjectService.getAllSubject()).thenReturn(subjectList);
        ResponseEntity<ResponseObject> response = subjectController.findAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("OK", response.getBody().getStatus());
        assertEquals("lay thong thin thanh cong", response.getBody().getMsg());

    }

    @Test
    void deleteSubject() {
        String subjectId = "valid_id";

        ResponseEntity<ResponseObject> response = subjectController.delete(subjectId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("OK", response.getBody().getStatus());
        assertEquals("Xoa thanh cong", response.getBody().getMsg());
        assertEquals("", response.getBody().getData());
        verify(subjectService, times(1)).DeleteSub(subjectId);
    }

    @Test
    void editSubject() {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setSubId("1");
        subjectDTO.setLanguage("PYTHON");

        ResponseEntity<ResponseObject> response = subjectController.editSubject(subjectDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("OK", response.getBody().getStatus());
        assertEquals("Sua thanh cong", response.getBody().getMsg());
        verify(subjectService, times(1)).editSubject(any(Subject.class));
    }
}
