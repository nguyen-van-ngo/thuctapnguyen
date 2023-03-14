package com.example.demothuctap.models.testdto.testmap;

import com.example.demothuctap.models.dto.CenterDTO;
import com.example.demothuctap.models.dto.mapper.CenterMapper;
import com.example.demothuctap.models.entity.Center;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestCenterMapper {

    @BeforeEach
    void setUp() {
    }

    @Test
    void toCenter() {
        CenterDTO centerDTO = new CenterDTO("1","CHICHI",
                "TIEN TAN, HA NAM, VIET NAM", "0986271059");
        CenterMapper centerMapper = new CenterMapper();
        Center center = centerMapper.toCenter(centerDTO);
        assertEquals("1",center.getCenCode());
        assertEquals("CHICHI",center.getCenName());
        assertEquals("TIEN TAN, HA NAM, VIET NAM",center.getCenAddress());
        assertEquals("0986271059",center.getCenPhone());
    }
}