package com.example.demothuctap.service.implement;

import com.example.demothuctap.exception.NotFoundException;
import com.example.demothuctap.exception.NotImplementedException;
import com.example.demothuctap.models.entity.Center;
import com.example.demothuctap.models.entity.Fresher;
import com.example.demothuctap.respositories.CenterRepository;
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
public class TestCenServiceIplm {
        @Mock
        CenterRepository centerRepository;
        @InjectMocks
        CenterServiceImpl centerService;
        private Center center;

        @BeforeEach
        void setUp() {
            center = new Center();
            center.setCenCode("1");
        }

        @Test
        void getAllCenter() {
            List<Center> centerList = new ArrayList<>();
            centerList.add(mock(Center.class));
            centerList.add(mock(Center.class));
            when(centerRepository.findAll()).thenReturn(centerList);
            List<Center> centers = centerService.getAllCenter();
            int num = centers.size();
            assertThat(num).isEqualTo(centerList.size());
            verify(centerRepository).findAll();
        }

        @Test
        void addCenter() {
            when(centerRepository.findById(center.getCenCode()))
                    .thenReturn(Optional.empty());
            when(centerRepository.save(center)).thenReturn(center);
            Center center1 = centerService.addCenter(center);
            assertThat(center1).isNotNull();
        }

        @Test
        void addCenterButException() {
            when(centerRepository.findById(center.getCenCode()))
                    .thenReturn(Optional.of(center));
            assertThrows(NotImplementedException.class, () -> {
                centerService.addCenter(center);
            });
            verify(centerRepository, times(1)).findById(center.getCenCode());
            verify(centerRepository, never()).save(center);
        }

        @Test
        void deleteCenter() {
            when(centerRepository.existsById(center.getCenCode()))
                    .thenReturn(Boolean.TRUE);
            centerService.deleteCenter(center.getCenCode());
            verify(centerRepository).deleteById(center.getCenCode());
        }

        @Test
        void deleteCenterButException() {
            String id = "1";
            when(centerRepository.existsById(center.getCenCode()))
                    .thenReturn(Boolean.FALSE);
            assertThrows(NotFoundException.class, () -> {
                centerService.deleteCenter(id);
            });
            verify(centerRepository, never()).deleteById(id);
        }

        @Test
        void editCenter() {
            when(centerRepository.findById(center.getCenCode())).thenReturn(Optional.of(center));
            when(centerRepository.save(center)).thenReturn(center);
            Center upCenter = centerRepository.findById(center.getCenCode())
                    .map(center1 -> {
                        center1.setCenName(center1.getCenName());
                        center1.setCenAddress(center1.getCenAddress());
                        center1.setCenPhone(center1.getCenPhone());
                        return centerRepository.save(center1);
                    }).orElseGet(() -> centerRepository.save(center));
            Center newCenter = centerService.editCenter(center);
            assertEquals(newCenter, upCenter);
        }

        @Test
        void editCenterButException() {
            when(centerRepository.findById(center.getCenCode())).thenReturn(Optional.empty());
            when(centerRepository.save(center)).thenReturn(center);
            Center upCenter = centerRepository.findById(center.getCenCode())
                    .map(center1 -> {
                        center1.setCenName(center1.getCenName());
                        center1.setCenAddress(center1.getCenAddress());
                        center1.setCenPhone(center1.getCenPhone());
                        return centerRepository.save(center1);
                    }).orElseGet(() -> centerRepository.save(center));
            Center newCenter = centerService.editCenter(center);
            assertEquals(newCenter, upCenter);
        }

        @Test
        void getListFresherOfCenter() {
            List<Fresher> freshers = new ArrayList<>();
            freshers.add(mock(Fresher.class));
            freshers.add(mock(Fresher.class));
            when(centerRepository.getFresOfCen(center.getCenCode())).thenReturn(freshers);

            List<Fresher> fresherList = centerService.getListFresherOfCenter(center.getCenCode());
            int size = fresherList.size();
            assertThat(size).isEqualTo(freshers.size());
        }

        @Test
        void getListFresherOfCenterButException() {
            List<Fresher> freshers = new ArrayList<>();

            when(centerRepository.getFresOfCen(center.getCenCode())).thenReturn(freshers);
            assertThrows(NotFoundException.class, () -> {
                centerService.getListFresherOfCenter(center.getCenCode());
            });
        }
    }