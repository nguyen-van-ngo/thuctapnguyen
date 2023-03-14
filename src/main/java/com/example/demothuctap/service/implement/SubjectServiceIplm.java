package com.example.demothuctap.service.implement;

import com.example.demothuctap.exception.NotFoundException;
import com.example.demothuctap.exception.NotImplementedException;
import com.example.demothuctap.models.entity.Fresher;
import com.example.demothuctap.models.entity.Subject;
import com.example.demothuctap.models.response.ErrorMessages;
import com.example.demothuctap.respositories.SubjectRepository;
import com.example.demothuctap.service.serviceinterface.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceIplm implements SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public Subject addSub(Subject subject) {
        Optional<Subject> subjectOptional = subjectRepository.findById(subject.getSubId());
        if (subjectOptional.isPresent()) {
            throw new NotImplementedException(ErrorMessages.SUBJECT_EXITS);
        }
        return subjectRepository.save(subject);
    }

    @Override
    public List<Subject> getAllSubject() {
        return subjectRepository.findAll();
    }

    @Override
    public void DeleteSub(String Subid) {
        boolean exists = subjectRepository.existsById(Subid);
        if (!exists) {
            throw new NotFoundException(ErrorMessages.CENTER_NULL);
        }
        subjectRepository.deleteById(Subid);
    }

    @Override
    public Subject editSubject(Subject subject) {
        return subjectRepository.findById(subject.getSubId())
                .map(f -> {
                    f.setLanguage(subject.getLanguage());
                    return subjectRepository.save(f);
                }).orElseGet(() -> subjectRepository.save(subject));
    }
}
