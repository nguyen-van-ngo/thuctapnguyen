package com.example.demothuctap.service.implement;

import com.example.demothuctap.exception.NotFoundException;
import com.example.demothuctap.exception.NotImplementedException;
import com.example.demothuctap.models.entity.Subject;
import com.example.demothuctap.respositories.SubjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TestSubjectServiceIplm {
    @Mock
    SubjectRepository subjectRepository;
    @InjectMocks
    SubjectServiceIplm subjectServiceIplm;
    private Subject subject;
    @BeforeEach
    void setUp() {
        subject = new Subject();
        subject.setSubId("1");
    }

    @Test
    void addSubject() {
        when(subjectRepository.findById(subject.getSubId()))
                .thenReturn(Optional.empty());
        when(subjectRepository.save(subject)).thenReturn(subject);
        Subject subject1 = subjectServiceIplm.addSub(subject);
        assertThat(subject1).isNotNull();
    }

    @Test
    void addSubjectButException(){
        when(subjectRepository.findById(subject.getSubId()))
                .thenReturn(Optional.of(subject));
        assertThrows(NotImplementedException.class,()->{
            subjectServiceIplm.addSub(subject);
        });
        verify(subjectRepository,times(1)).findById(subject.getSubId());
        verify(subjectRepository, never()).save(subject);
    }

    @Test
    void getAllSubject() {
        List<Subject> subjectList = new ArrayList<>();
        subjectList.add(mock(Subject.class));
        subjectList.add(mock(Subject.class));

        when(subjectRepository.findAll()).thenReturn(subjectList);

        List<Subject> subjects = subjectServiceIplm.getAllSubject();
        int num = subjects.size();
        assertThat(num).isEqualTo(subjectList.size());
        verify(subjectRepository).findAll();
    }

    @Test
    void deleteSubject() {
        when(subjectRepository.existsById(subject.getSubId()))
                .thenReturn(Boolean.TRUE);
        subjectServiceIplm.DeleteSub(subject.getSubId());
        verify(subjectRepository).deleteById(subject.getSubId());
    }
    @Test
    void deleteSubjectButException(){
        String id = "1";
        when(subjectRepository.existsById(subject.getSubId()))
                .thenReturn(Boolean.FALSE);
        assertThrows(NotFoundException.class,()->{
            subjectServiceIplm.DeleteSub(id);
        });
        verify(subjectRepository,never()).deleteById(id);
    }

    @Test
    void editSubject() {
        when(subjectRepository.findById(subject.getSubId())).thenReturn(Optional.of(subject));
        when(subjectRepository.save(subject)).thenReturn(subject);
        Subject upSubject = subjectRepository.findById(subject.getSubId())
                .map(subject1 ->  {
                    subject1.setSubId(subject1.getSubId());
                    subject1.setLanguage(subject1.getLanguage());
                    return subjectRepository.save(subject1);
                }).orElseGet(()-> subjectRepository.save(subject));
        Subject newSubject = subjectServiceIplm.editSubject(subject);
        assertEquals(newSubject, upSubject);
    }
    @Test
    void editSubjectButException(){
        when(subjectRepository.findById(subject.getSubId())).thenReturn(Optional.empty());
        when(subjectRepository.save(subject)).thenReturn(subject);
        Subject upSubject = subjectRepository.findById(subject.getSubId())
                .map(subject1 ->  {
                    subject1.setSubId(subject1.getSubId());
                    subject1.setLanguage(subject1.getLanguage());
                    return subjectRepository.save(subject1);
                }).orElseGet(()-> subjectRepository.save(subject));
        Subject newSubject = subjectServiceIplm.editSubject(subject);
        assertEquals(newSubject, upSubject);
    }

}