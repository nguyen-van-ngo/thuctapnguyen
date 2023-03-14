package com.example.demothuctap.controllers;

import com.example.demothuctap.models.dto.ScoreDTO;
import com.example.demothuctap.models.dto.mapper.ScoreMapper;
import com.example.demothuctap.models.entity.Score;
import com.example.demothuctap.models.response.ResponseObject;
import com.example.demothuctap.service.serviceinterface.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/link")
public class LinkController {
    @Autowired
    LinkService linkService;
    @PostMapping("/addscore")
    public @ResponseBody ResponseEntity<ResponseObject> addScore(@RequestBody ScoreDTO scoreDTO) {
        ScoreMapper scoreMapper = new ScoreMapper();
        Score score = scoreMapper.toScore(scoreDTO);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Add score successfully",
                        linkService.addScore(score, scoreDTO.getFresID(), scoreDTO.getSubId()))
        );
    }

    @PostMapping("/fc/{cenCode}")
    public @ResponseBody ResponseEntity<ResponseObject> adFresherToCenter(@RequestParam String fresID,
                                                                          @PathVariable String cenCode) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Add fresher to center successfully",
                        linkService.addFresherToCenter(fresID,cenCode))
        );
    }
}
