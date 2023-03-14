package com.example.demothuctap.controllers;

import com.example.demothuctap.models.dto.mapper.FresherMapper;
import com.example.demothuctap.models.entity.Fresher;
import com.example.demothuctap.service.serviceinterface.FresherService;
import com.example.demothuctap.models.dto.FresherDTO;
import com.example.demothuctap.models.response.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;

@RestController
@RequestMapping("/fresher")
public class FresherController {
    @Autowired
    FresherService fresService;

    @GetMapping("/all")
    public @ResponseBody ResponseEntity<ResponseObject> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Get all fresher successfully",
                        Collections.singletonList(fresService.getAllFresher()))
        );
    }
    @PostMapping("/add")
    public @ResponseBody ResponseEntity<ResponseObject> addFresher(@RequestBody FresherDTO fresherDTO) {
        FresherMapper fresherMapper = new FresherMapper();
        Fresher fresher = fresherMapper.toFresher(fresherDTO);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Insert fresher successfully",
                        fresService.addFresher(fresher))
        );
    }
    @PutMapping("/put")
    public @ResponseBody ResponseEntity<ResponseObject> editFresher(@RequestBody FresherDTO fresherDTO) {
        FresherMapper fresherMapper = new FresherMapper();
        Fresher fresher = fresherMapper.toFresher(fresherDTO);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok", "Change or insert fresher successfully",
                        fresService.editFresher(fresher))
        );
    }
    @DeleteMapping("/delete/{fresID}")
    public ResponseEntity<ResponseObject> delete(@PathVariable String fresID) {
        fresService.deleteFresher(fresID);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Delete fresher successfully","")
        );
    }
    @GetMapping("/transcript")
    public ResponseEntity<ResponseObject> getTranscript(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Get transcript successfully",
                        Collections.singletonList(fresService.getTranscript()))
        );
    }
    @GetMapping("/search/name")
    public ResponseEntity<ResponseObject> searchFresherWithfresName(@RequestParam String fresName){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Search Fresher with fresher name successfully",
                        Collections.singletonList(fresService.searchFresherWithfresName(fresName)))
        );
    }
    @GetMapping("/search/mail")
    public ResponseEntity<ResponseObject> searchFresherWithfresEmail(@RequestParam String fresEmail){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Search Fresher with fresher mail successfully",
                        fresService.searchFresherWithfresEmail(fresEmail))
        );
    }
    @GetMapping("/search/language")
    public ResponseEntity<ResponseObject> searchFresherWithlanguage(@RequestParam String language){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Search Fresher with language programming successfully",
                        Collections.singletonList(fresService.searchFresherWithlanguage(language)))
        );
    }
}