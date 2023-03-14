package com.example.demothuctap.service.implement;

import com.example.demothuctap.exception.NotFoundException;
import com.example.demothuctap.exception.NotImplementedException;
import com.example.demothuctap.models.entity.Fresher;
import com.example.demothuctap.models.response.Transcript;
import com.example.demothuctap.respositories.FresherRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TestFresherServiceImpl {
    @Mock
    FresherRepository fresherRepository;
    @InjectMocks
    FresherServiceImpl fresherService;
    private Fresher fresher;
    @BeforeEach
    void setUp() {
        fresher = new Fresher();
        fresher.setFresID("2019607115");
        fresher.setFresName("Nguyen");
        fresher.setFresAddress("Ha Noi");
        fresher.setFresPhone("0986217059");
        fresher.setFresEmail("nguyenngo@gmail.com");
    }
    @DisplayName("Test cho getallFresher")
    @Test
    void getAllFresher() {
        List<Fresher> freshers = new ArrayList<>();
        freshers.add(mock(Fresher.class));
        freshers.add(mock(Fresher.class));
        when(fresherRepository.findAll()).thenReturn(freshers);
        List<Fresher> list = fresherService.getAllFresher();
        int size = list.size();
        assertThat(size).isEqualTo(freshers.size());
        verify(fresherRepository).findAll();
    }
    @DisplayName("Test cho GetTranscript")
    @Test
    void getTranscript() {
        List<Transcript>transcripts = new ArrayList<>();
        transcripts.add(mock(Transcript.class));
        transcripts.add(mock(Transcript.class));
        when(fresherRepository.getTranscript()).thenReturn(transcripts);
        List<Transcript> list = fresherService.getTranscript();
        int size = list.size();
        assertThat(size).isEqualTo(transcripts.size());
        verify(fresherRepository).getTranscript();
    }
    @DisplayName("Test cho addFresher")
    @Test
    void addFresher() {
        given(fresherRepository.save(fresher)).willReturn(fresher);
        Fresher fresher1 = fresherService.addFresher(fresher);
        assertThat(fresher1).isNotNull();
    }
    @DisplayName("Test cho ngoai le cua addFresher")
    @Test
    void addFresherExcep(){
        when(fresherRepository.findById(fresher.getFresID()))
                .thenReturn(Optional.of(fresher));
        assertThrows(NotImplementedException.class,()->{
            fresherService.addFresher(fresher);
        });
        verify(fresherRepository,times(1)).findById(fresher.getFresID());
        verify(fresherRepository,never()).save(any(Fresher.class));
    }

    @DisplayName("Test cho deleteFresher")
    @Test
    void deleteFresher() {
        when(fresherRepository.existsById(fresher.getFresID()))
                .thenReturn(Boolean.TRUE);
        fresherService.deleteFresher(fresher.getFresID());
        verify(fresherRepository).deleteById(fresher.getFresID());
    }
    @DisplayName("Test cho ngoai le deleteFresher")
    @Test
    void deleteFresherExcep() {
        String id = "2019200112";
        when(fresherRepository.existsById(id))
                .thenReturn(false); // sử dụng boolean giống với giá trị trả về của existsById
        assertThrows(NotFoundException.class, () -> {
            fresherService.deleteFresher(id);
        });
        verify(fresherRepository, never()).deleteById(id);
    }

    @DisplayName("test cho search name fresher")
    @Test
    void searchFresWithName() {
        List<Fresher> freshers = new ArrayList<>();
        freshers.add(mock(Fresher.class));
        freshers.add(mock(Fresher.class));
        when(fresherRepository.findByfresName(fresher.getFresName()))
                .thenReturn(freshers);

        List<Fresher> list = fresherService.searchFresherWithfresName(fresher.getFresName());
        int size = list.size();
        Assertions.assertThat(size).isEqualTo(freshers.size());
        verify(fresherRepository).findByfresName(fresher.getFresName());
    }

    @DisplayName("test cho ngoai le search name fresher")
    @Test
    void searchFresWithNameButExcep() {
        String name = fresher.getFresName();
        List<Fresher> freshers = new ArrayList<>();
        when(fresherRepository.findByfresName(name))
                .thenReturn(freshers);
        assertThrows(NotFoundException.class,()->{
            fresherService.searchFresherWithfresName(name);
        });
        verify(fresherRepository, times(1)).findByfresName(name);
    }

    @DisplayName("Test search Fresher bang Email")
    @Test
    void searchFresWithEmail() {
        Fresher fresher = mock(Fresher.class);
        when(fresherRepository.findByfresEmail(fresher.getFresEmail()))
                .thenReturn(Optional.of(fresher));
        Fresher fresherOptional = fresherService.searchFresherWithfresEmail(fresher.getFresEmail());
        Assertions.assertThat(fresherOptional.getFresID()).isEqualTo(fresher.getFresID());
        verify(fresherRepository).findByfresEmail(fresher.getFresEmail());
    }

    @DisplayName("Test cho ngoai le search Fresher bang Email")
    @Test
    void searchFresWithEmailButExcep() {
        String email = fresher.getFresEmail();
        when(fresherRepository.findByfresEmail(email))
                .thenReturn(Optional.empty());
        assertThrows(NotFoundException.class,()->{
            fresherService.searchFresherWithfresEmail(email);
        });
        verify(fresherRepository,times(1)).findByfresEmail(email);
    }

    @DisplayName("Test cho search fresher bang language")
    @Test
    void searchFresLangua() {
        String language = "JAVA";
        List<Fresher> freshers = new ArrayList<>();
        freshers.add(mock(Fresher.class));
        freshers.add(mock(Fresher.class));
        when(fresherRepository.findByFresherWithlanguage(language))
                .thenReturn(freshers);
        List<Fresher> list = fresherService.searchFresherWithlanguage(language);
        int size = list.size();
        Assertions.assertThat(size).isEqualTo(freshers.size());
        verify(fresherRepository).findByFresherWithlanguage(language);
    }

    @Test
    void searchFresWithLangExcep() {
        String language = "JAVA";
        List<Fresher> freshers = new ArrayList<>();
        when(fresherRepository.findByFresherWithlanguage(language))
                .thenReturn(freshers);
        assertThrows(NotFoundException.class,()->{
            fresherService.searchFresherWithlanguage(language);
        });
        verify(fresherRepository,times(1)).findByFresherWithlanguage(language);
    }

    @Test
    void editFresher() {
        when(fresherRepository.findById(fresher.getFresID())).thenReturn(Optional.of(fresher));
        when(fresherRepository.save(fresher)).thenReturn(fresher);
        Fresher newFresher = fresherRepository.findById(fresher.getFresID())
                .map(f -> {
                    f.setFresName(fresher.getFresName());
                    f.setFresAddress(fresher.getFresAddress());
                    f.setFresPhone(fresher.getFresPhone());
                    f.setFresEmail(fresher.getFresEmail());
                    return fresherRepository.save(f);
                }).orElseGet(()-> fresherRepository.save(fresher));
        Fresher upfresher = fresherService.editFresher(fresher);
        assertEquals(upfresher, newFresher);
    }
    @Test
    void editFresherExcep() {
        when(fresherRepository.findById(fresher.getFresID())).thenReturn(Optional.empty());
        when(fresherRepository.save(fresher)).thenReturn(fresher);
        Fresher newFresher = fresherRepository.findById(fresher.getFresID())
                .map(f -> {
                    f.setFresName(fresher.getFresName());
                    f.setFresAddress(fresher.getFresAddress());
                    f.setFresPhone(fresher.getFresPhone());
                    f.setFresEmail(fresher.getFresEmail());
                    return fresherRepository.save(f);
                }).orElseGet(()-> fresherRepository.save(fresher));
        Fresher upfresher = fresherService.editFresher(fresher);
        assertEquals(upfresher, newFresher);
    }
}