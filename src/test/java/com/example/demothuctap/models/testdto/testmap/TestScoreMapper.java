package com.example.demothuctap.models.testdto.testmap;

import com.example.demothuctap.models.dto.ScoreDTO;
import com.example.demothuctap.models.dto.mapper.ScoreMapper;
import com.example.demothuctap.models.entity.Score;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestScoreMapper {

    @Test
    void toScore() {
        ScoreDTO scoreDTO = new ScoreDTO(9.0,8.0,7.0,"","");
        ScoreMapper scoreMapper = new ScoreMapper();
        Score score = scoreMapper.toScore(scoreDTO);
        assertEquals(9.0,score.getScore01());
        assertEquals(8.0,score.getScore02());
        assertEquals(7.0,score.getScore03());
    }
}