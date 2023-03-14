package com.example.demothuctap.service.implement;

import com.example.demothuctap.models.entity.Center;
import com.example.demothuctap.models.entity.Fresher;
import com.example.demothuctap.models.entity.FresherCenter;
import com.example.demothuctap.respositories.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestLinkServiceIplm {
    @Mock
    FresherRepository fresherRepository;
    @Mock
    CenterRepository centerRepository;
    @Mock
    FresherCenterRepository fresherCenterRepository;
    @Mock
    SubjectRepository subjectRepository;
    @Mock
    ScoreRepository scoreRepository;
    @InjectMocks
    LinkServiceImpl linkService;

    @Test
    void addFresherToCenter() {
        String fresherId = "fresherId";
        String centerId  = "centerId";

        when(fresherRepository.findById(fresherId)).thenReturn(Optional.of(new Fresher()));
        when(centerRepository.findById(centerId)).thenReturn(Optional.of(new Center()));
        when(fresherCenterRepository.getFresCen(fresherId, centerId)).thenReturn(Optional.empty());
        assertEquals("Configuration", linkService.addFresherToCenter(fresherId, centerId));
        verify(fresherCenterRepository, times(1)).save(any(FresherCenter.class));
    }
}
