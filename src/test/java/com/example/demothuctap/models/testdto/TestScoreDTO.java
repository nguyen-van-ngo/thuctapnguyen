package com.example.demothuctap.models.testdto;

import com.example.demothuctap.models.dto.ScoreDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestScoreDTO {

    @Test
    void set_getScore01() {
        ScoreDTO scoreDTO = new ScoreDTO();
        scoreDTO.setScore01(10d);
        assertEquals(10d,scoreDTO.getScore01());
    }

    @Test
    void set_getScore02() {
        ScoreDTO scoreDTO = new ScoreDTO();
        scoreDTO.setScore02(10d);
        assertEquals(10d,scoreDTO.getScore02());
    }

    @Test
    void set_getScore03() {
        ScoreDTO scoreDTO = new ScoreDTO();
        scoreDTO.setScore03(10d);
        assertEquals(10d,scoreDTO.getScore03());
    }

    @Test
    void set_getFresId() {
        ScoreDTO scoreDTO = new ScoreDTO();
        scoreDTO.setFresID("2019607141");
        assertEquals("2019607141",scoreDTO.getFresID());
    }

    @Test
    void set_getSubId() {
        ScoreDTO scoreDTO = new ScoreDTO();
        scoreDTO.setSubId("FE6037");
        assertEquals("FE6037",scoreDTO.getSubId());
    }

    @Test
    void testScoreDTOConstructor() {
        ScoreDTO scoreDTO = new ScoreDTO(9d,10d,8d,"2019607141","FE6037");
        assertEquals(9d,scoreDTO.getScore01());
        assertEquals(10d,scoreDTO.getScore02());
        assertEquals(8d,scoreDTO.getScore03());
        assertEquals("2019607141",scoreDTO.getFresID());
        assertEquals("FE6037",scoreDTO.getSubId());
    }
}
