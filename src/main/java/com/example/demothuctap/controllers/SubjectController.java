package com.example.demothuctap.controllers;

import com.example.demothuctap.models.dto.FresherDTO;
import com.example.demothuctap.models.dto.SubjectDTO;
import com.example.demothuctap.models.dto.mapper.FresherMapper;
import com.example.demothuctap.models.dto.mapper.SubjectMapper;
import com.example.demothuctap.models.entity.Fresher;
import com.example.demothuctap.models.entity.Subject;
import com.example.demothuctap.models.response.ResponseObject;
import com.example.demothuctap.respositories.SubjectRepository;
import com.example.demothuctap.service.serviceinterface.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;
    @Autowired
    private SubjectRepository subjectRepository;

    @PostMapping("/add")
    public @ResponseBody ResponseEntity<ResponseObject> addSub(@RequestBody SubjectDTO subjectDTO) {
        SubjectMapper subjectMapper = new SubjectMapper();
        Subject subject = subjectMapper.toSubject(subjectDTO);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Insert fresher successfully",
                        subjectService.addSub(subject))
        );
    }
    @GetMapping("/all")
    public @ResponseBody ResponseEntity<ResponseObject> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","lay thong thin thanh cong",
                        Collections.singletonList(subjectService.getAllSubject()))
        );
    }
    @DeleteMapping("/delete/{SubId}")
    public @ResponseBody ResponseEntity<ResponseObject>delete(@PathVariable String SubId){
        subjectService.DeleteSub(SubId);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Xoa thanh cong","")
        );
    }
    @PutMapping("/put")
    public @ResponseBody ResponseEntity<ResponseObject>editSubject(@RequestBody SubjectDTO subjectDTO){
        SubjectMapper subjectMapper = new SubjectMapper();
        Subject subject = subjectMapper.toSubject(subjectDTO);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Sua thanh cong",subjectService.editSubject(subject))
        );
    }
}
