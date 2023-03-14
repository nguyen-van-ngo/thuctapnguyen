package com.example.demothuctap.service.implement;

import com.example.demothuctap.exception.NotFoundException;
import com.example.demothuctap.exception.NotImplementedException;
import com.example.demothuctap.models.entity.Fresher;
import com.example.demothuctap.models.response.ErrorMessages;
import com.example.demothuctap.models.response.Transcript;
import com.example.demothuctap.respositories.FresherRepository;
import com.example.demothuctap.service.serviceinterface.FresherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class FresherServiceImpl implements FresherService {
    @Autowired
    FresherRepository fresherRepository;

    @Override
    public List<Fresher> getAllFresher() {

        return fresherRepository.findAll();
    }
    @Override
    public List<Transcript> getTranscript() {

        return fresherRepository.getTranscript();
    }
    @Override
    public Fresher addFresher(Fresher fresher) {
        Optional<Fresher> fresherOptional = fresherRepository.findById(fresher.getFresID());
        if (fresherOptional.isPresent()) {
            throw new NotImplementedException(ErrorMessages.FRESHER_EXISTS);
        }
        return fresherRepository.save(fresher);
    }
    @Override
    public Fresher editFresher(Fresher fresher) {
        return fresherRepository.findById(fresher.getFresID())
                .map(f -> {
                    f.setFresName(fresher.getFresName());
                    f.setFresAddress(fresher.getFresAddress());
                    f.setFresPhone(fresher.getFresPhone());
                    f.setFresEmail(fresher.getFresEmail());
                    return fresherRepository.save(f);
                }).orElseGet(()-> fresherRepository.save(fresher));
    }
    @Override
    public void deleteFresher(String id) {
        boolean exists = fresherRepository.existsById(id);
        if(!exists) {
            throw new NotFoundException(ErrorMessages.FRESHER_NULL);
        }
        fresherRepository.deleteById(id);
    }
    @Override
    public List<Fresher> searchFresherWithfresName(String fresName) {
        List<Fresher> freshers = fresherRepository.findByfresName(fresName);
        if(freshers.isEmpty()) {
            throw new NotFoundException(ErrorMessages.FRESHER_NULL);
        }
        return freshers;
    }
    @Override
    public Fresher searchFresherWithfresEmail(String fresEmail) {
        Optional<Fresher> getFresher = fresherRepository.findByfresEmail(fresEmail);
        if(getFresher.isPresent()){
            return getFresher.get();
        }
        throw new NotFoundException(ErrorMessages.FRESHER_NULL);
    }
    @Override
    public List<Fresher> searchFresherWithlanguage(String language){
        List<Fresher> fresherList = fresherRepository.findByFresherWithlanguage(language);
        if(fresherList.isEmpty()){
            throw new NotFoundException(ErrorMessages.FRESHER_NULL);
        }
        return fresherList;
    }
}
