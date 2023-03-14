package com.example.demothuctap.service.serviceinterface;

import com.example.demothuctap.models.dto.SubjectDTO;
import com.example.demothuctap.models.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Objects;

public interface SubjectService {
    Subject addSub( Subject subject);

    List<Subject>getAllSubject();

    void DeleteSub(String subId);

    Subject editSubject(Subject subject);
}
