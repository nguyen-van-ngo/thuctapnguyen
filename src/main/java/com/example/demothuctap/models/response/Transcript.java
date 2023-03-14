package com.example.demothuctap.models.response;

import com.example.demothuctap.models.entity.Score;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
public class Transcript extends Score {
    private String fresName;
    private String language;
    private Double score01;
    private Double score02;
    private Double score03;
    private Double average;

    public Transcript(String fresName, String language, Double score01, Double score02, Double score03, Double average) {
        this.fresName = fresName;
        this.language = language;
        this.score01 = score01;
        this.score02 = score02;
        this.score03 = score03;
        this.average = (double)Math.round(average * 100) / 100;
    }
    public Transcript(Score score) {
        this.fresName = score.getFresher().getFresName();
        this.language = score.getSubject().getLanguage();
        this.score01 = score.getScore01();
        this.score02 = score.getScore02();
        this.score03 = score.getScore03();
        this.average = (double)Math.round(((score01+score02+score03)/3) * 100) / 100;
    }
}