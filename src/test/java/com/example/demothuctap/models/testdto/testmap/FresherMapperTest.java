package com.example.demothuctap.models.testdto.testmap;

import com.example.demothuctap.models.dto.FresherDTO;
import com.example.demothuctap.models.dto.mapper.FresherMapper;
import com.example.demothuctap.models.entity.Fresher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FresherMapperTest {

    @Test
    void toFresher() {
        FresherDTO fresherDTO = new FresherDTO("2019607141","nguyen","MAC",
                "0985217059","nguyenngo@gmail.com");
        FresherMapper fresherMapper = new FresherMapper();
        Fresher fresher = fresherMapper.toFresher(fresherDTO);
        assertEquals("2019607141",fresher.getFresID());
        assertEquals("nguyen",fresher.getFresName());
        assertEquals("MAC",fresher.getFresAddress());
        assertEquals("0985217059",fresher.getFresPhone());
        assertEquals("nguyenngo@gmail.com",fresher.getFresEmail());
    }
}