package com.example.demothuctap.service.serviceinterface;

import com.example.demothuctap.models.entity.Fresher;

import java.util.List;

public interface ScoreService {
    List<Fresher> getAllFresherWithScore(Double average);
}
