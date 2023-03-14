package com.example.demothuctap.models.testdto;

import com.example.demothuctap.models.dto.CenterDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestCenterDTO {

    @Test
    void getCenCode() {
        CenterDTO centerDTO = new CenterDTO();
        centerDTO.setCenCode("a1");
        assertEquals("a1",centerDTO.getCenCode());
    }

    @Test
    void getCenName() {
        CenterDTO centerDTO = new CenterDTO();
        centerDTO.setCenName("Trung tap giao duc thuong xuyen");
        assertEquals("Trung tap giao duc thuong xuyen",centerDTO.getCenName());
    }

    @Test
    void getCenAddress() {
        CenterDTO centerDTO = new CenterDTO();
        centerDTO.setCenAddress("Duong 32, Bac Tu Liem,Ha NOI ");
        assertEquals("Duong 32, Bac Tu Liem,Ha NOI ",centerDTO.getCenAddress());
    }

    @Test
    void getCenPhone() {
        CenterDTO centerDTO = new CenterDTO();
        centerDTO.setCenPhone("0986217059");
        assertEquals("0986217059",centerDTO.getCenPhone());
    }
    @Test
    void testCenDTOConstructor() {
        CenterDTO centerDTO = new CenterDTO("a1","Trung tap giao duc thuong xuyen",
                "Duong 32, Bac Tu Liem,Ha NOI ", "0986217059");
        assertEquals("a1",centerDTO.getCenCode());
        assertEquals("Trung tap giao duc thuong xuyen",centerDTO.getCenName());
        assertEquals("Duong 32, Bac Tu Liem,Ha NOI ",centerDTO.getCenAddress());
        assertEquals("0986217059",centerDTO.getCenPhone());
    }
}