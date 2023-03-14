package com.example.demothuctap.service.implement;

import com.example.demothuctap.exception.NotFoundException;
import com.example.demothuctap.models.entity.*;
import com.example.demothuctap.models.response.ErrorMessages;
import com.example.demothuctap.models.response.Transcript;
import com.example.demothuctap.respositories.*;
import com.example.demothuctap.service.serviceinterface.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    FresherRepository fresherRepository;
    @Autowired
    CenterRepository centerRepository;
    @Autowired
    FresherCenterRepository fresherCenterRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    ScoreRepository scoreRepository;

    @Override
    public String addFresherToCenter(String fresID, String cenCode) {
        Optional<Fresher> fresher = fresherRepository.findById(fresID);
        Optional<Center> center = centerRepository.findById(cenCode);
        FresherCenter fresherCenter = new FresherCenter();
        if (fresher.isEmpty()) {
            throw new NotFoundException(ErrorMessages.FRESHER_NULL);
        }else if(center.isEmpty()) {
            throw new NotFoundException(ErrorMessages.CENTER_NULL);
        }else if (fresherCenterRepository.getFresCen(fresID,cenCode).isPresent()){
            throw new NotFoundException(ErrorMessages.FRESHER_CENTER);
        }
        fresherRepository.findById(fresID).ifPresent(fresherCenter::setFresher);
        centerRepository.findById(cenCode).ifPresent(fresherCenter::setCenter);
        fresherCenterRepository.save(fresherCenter);
        return "Configuration";
    }
    @Override
    public Transcript addScore(Score score, String fresID, String subId) {
        Optional<Fresher> fresher = fresherRepository.findById(fresID);
        Optional<Subject> subject = subjectRepository.findById(subId);
        if (fresher.isEmpty()) {
            throw new NotFoundException(ErrorMessages.FRESHER_NULL);
        }else if(subject.isEmpty()) {
            throw new NotFoundException(ErrorMessages.SUBJECT_NULL);
        }else if (scoreRepository.getScore(fresID,subId).isPresent()){
            throw new NotFoundException(ErrorMessages.SCORE_EXISTS);
        }
        fresherRepository.findById(fresID).ifPresent(score::setFresher);
        subjectRepository.findById(subId).ifPresent(score::setSubject);
        scoreRepository.save(score);
        return new Transcript(score);
    }

}