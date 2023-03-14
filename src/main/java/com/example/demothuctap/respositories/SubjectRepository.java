package com.example.demothuctap.respositories;

import com.example.demothuctap.models.entity.Fresher;
import com.example.demothuctap.models.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {
}
