package com.example.demothuctap.models.dto.mapper;

import com.example.demothuctap.models.dto.CenterDTO;
import com.example.demothuctap.models.entity.Center;

public class CenterMapper {
    public Center toCenter(CenterDTO centerDTO) {
        Center center = new Center();
        center.setCenCode(centerDTO.getCenCode());
        center.setCenPhone(centerDTO.getCenPhone());
        center.setCenName(centerDTO.getCenName());
        center.setCenAddress(centerDTO.getCenAddress());
        return center;
    }
}
