package com.example.demothuctap.service.serviceinterface;

import com.example.demothuctap.models.entity.Score;

public interface LinkService {
    String addFresherToCenter(String cenCode, String fresID);

    Score addScore(Score score, String fresID, String subId);
}
