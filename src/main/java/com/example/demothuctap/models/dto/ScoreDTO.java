package com.example.demothuctap.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class ScoreDTO {
    private Double score01;
    private Double score02;
    private Double score03;
    private String fresID;
    private String subId;
}
