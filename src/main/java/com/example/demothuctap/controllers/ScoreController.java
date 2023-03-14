package com.example.demothuctap.controllers;

import com.example.demothuctap.models.entity.Score;
import com.example.demothuctap.models.response.ResponseObject;
import com.example.demothuctap.respositories.ScoreRepository;
import com.example.demothuctap.service.serviceinterface.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
@RestController
@RequestMapping("/score")
public class ScoreController {
        @Autowired
        ScoreService scoreService;
        @GetMapping("/getfresher/{average}")
        public ResponseEntity<ResponseObject> getAllFresherWithScore (@PathVariable Double average){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Ok","Nhan fresher bang score thanh cong",
                            Collections.singletonList(scoreService.getAllFresherWithScore(average)))
            );
        }
}
