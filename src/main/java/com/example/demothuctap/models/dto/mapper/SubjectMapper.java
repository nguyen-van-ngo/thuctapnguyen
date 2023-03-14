package com.example.demothuctap.models.dto.mapper;

import com.example.demothuctap.models.dto.SubjectDTO;
import com.example.demothuctap.models.entity.Subject;

public class SubjectMapper {
    public Subject toSubject(SubjectDTO subjectDTO) {
        Subject subject = new Subject();
        subject.setSubId(subjectDTO.getSubId());
        subject.setLanguage(subjectDTO.getLanguage());
        return subject;
    }
}
