package com.example.demothuctap.service.implement;

import com.example.demothuctap.exception.NotFoundException;
import com.example.demothuctap.models.entity.Fresher;
import com.example.demothuctap.models.response.ErrorMessages;
import com.example.demothuctap.respositories.ScoreRepository;
import com.example.demothuctap.service.serviceinterface.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    ScoreRepository scoreRepository;
    @Override
    public List<Fresher> getAllFresherWithScore(Double averages) {
        List<Fresher> list = scoreRepository.findFresherByScore(averages);
        if (list.isEmpty()) {
            throw new NotFoundException(ErrorMessages.FRESHER_NULL);
        }
        return list;
    }
}