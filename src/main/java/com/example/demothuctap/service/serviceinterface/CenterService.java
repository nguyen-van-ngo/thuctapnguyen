package com.example.demothuctap.service.serviceinterface;

import com.example.demothuctap.models.entity.Center;
import com.example.demothuctap.models.entity.Fresher;

import java.util.List;

public interface CenterService {
    List<Center> getAllCenter();

    Center addCenter(Center center);

    void deleteCenter(String id);

    Center editCenter(Center center);

    List<Fresher> getListFresherOfCenter(String string);
}
