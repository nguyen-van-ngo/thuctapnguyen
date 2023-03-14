package com.example.demothuctap.models.testdto.testmap;

import com.example.demothuctap.models.dto.SubjectDTO;
import com.example.demothuctap.models.dto.mapper.SubjectMapper;
import com.example.demothuctap.models.entity.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestSubjectMapper {

    @Test
    void toSubject() {
        SubjectDTO subjectDTO = new SubjectDTO("2","PYTHON");
        SubjectMapper subjectMapper = new SubjectMapper();
        Subject subject = subjectMapper.toSubject(subjectDTO);
        assertEquals("2",subject.getSubId());
        assertEquals("PYTHON",subject.getLanguage());
    }
}