package com.example.demothuctap.models.dto.mapper;

import com.example.demothuctap.models.dto.FresherDTO;
import com.example.demothuctap.models.entity.Fresher;

public class FresherMapper {
    public Fresher toFresher(FresherDTO fresherDTO) {
        Fresher fresher = new Fresher();
        fresher.setFresID(fresherDTO.getFresID());
        fresher.setFresName(fresherDTO.getFresName());
        fresher.setFresAddress(fresherDTO.getFresAddress());
        fresher.setFresPhone(fresherDTO.getFresPhone());
        fresher.setFresEmail(fresherDTO.getFresEmail());
        return fresher;
    }
}

