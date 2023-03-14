package com.example.demothuctap.models.testdto;

import com.example.demothuctap.models.dto.SubjectDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSubjectDTO {
    @Test
    void getSubjectId() {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setSubId("1");
        assertEquals("1",subjectDTO.getSubId());
    }

    @Test
    void getlanguage() {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setLanguage("Java");
        assertEquals("Java",subjectDTO.getLanguage());
    }
    @Test
    void testSubjectDTOConstructor() {
        SubjectDTO subjectDTO = new SubjectDTO("1","Java");
        assertEquals("1",subjectDTO.getSubId());
        assertEquals("Java",subjectDTO.getLanguage());

    }
}
