package com.example.demothuctap.service.implement;

import com.example.demothuctap.exception.NotFoundException;
import com.example.demothuctap.exception.NotImplementedException;
import com.example.demothuctap.models.entity.Center;
import com.example.demothuctap.models.entity.Fresher;
import com.example.demothuctap.models.response.ErrorMessages;
import com.example.demothuctap.respositories.CenterRepository;
import com.example.demothuctap.service.serviceinterface.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CenterServiceImpl implements CenterService {
    @Autowired
    CenterRepository centerRepository;
    @Override
    public List<Center> getAllCenter(){
        return centerRepository.findAll();
    }
    @Override
    public Center addCenter(Center center) {
        Optional<Center> centerList = centerRepository.findById(center.getCenCode());
        if(centerList.isPresent()) {
            throw new NotImplementedException(ErrorMessages.CENTER_EXISTS);
        }
        return centerRepository.save(center);
    }
    @Override
    public void deleteCenter(String id) {
        boolean exists = centerRepository.existsById(id);
        if(!exists) {
            throw new NotFoundException(ErrorMessages.CENTER_NULL);
        }
        centerRepository.deleteById(id);
    }
    @Override
    public Center editCenter(Center center) {
        return centerRepository.findById(center.getCenCode())
                .map(center1 -> {
                    center1.setCenPhone(center.getCenPhone());
                    center1.setCenAddress(center.getCenAddress());
                    center1.setCenName(center.getCenName());
                    return centerRepository.save(center1);
                }).orElseGet(()-> centerRepository.save(center));
    }
    @Override
    public List<Fresher> getListFresherOfCenter(String string) {
        List<Fresher> fresherList = centerRepository.getFresOfCen(string);
        if(!fresherList.isEmpty()) {
            return fresherList;
        }
        throw new NotFoundException(ErrorMessages.FRESHER_NULL);
    }
}