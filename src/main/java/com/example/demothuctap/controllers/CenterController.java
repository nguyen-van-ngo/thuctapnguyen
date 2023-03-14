package com.example.demothuctap.controllers;

import com.example.demothuctap.models.dto.mapper.CenterMapper;
import com.example.demothuctap.models.entity.Center;
import com.example.demothuctap.models.dto.CenterDTO;
import com.example.demothuctap.service.serviceinterface.CenterService;
import com.example.demothuctap.models.response.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/center")
public class CenterController {
    @Autowired
    CenterService cenService;
    @GetMapping("/all")
    public ResponseEntity<ResponseObject> getAllCenter() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Get all center successfully",
                        Collections.singletonList(cenService.getAllCenter()))
        );
    }
    @GetMapping(path = "/fresher/{cenCode}")
    public ResponseEntity<ResponseObject> getAllFresherOfCenter(@PathVariable String cenCode) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok","Get All fresher of center " + cenCode,
                        Collections.singletonList(cenService.getListFresherOfCenter(cenCode)))
        );
    }
    @PostMapping("/add")
    public ResponseEntity<ResponseObject> addCenter(@RequestBody CenterDTO centerDTO) {
        CenterMapper centerMapper = new CenterMapper();
        Center center = centerMapper.toCenter(centerDTO);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Insert center successfully",
                        Collections.singletonList(cenService.addCenter(center)))
        );
    }
    @PutMapping("/put")
    public @ResponseBody ResponseEntity<ResponseObject> editCenter(@RequestBody CenterDTO centerDTO) {
        CenterMapper centerMapper = new CenterMapper();
        Center center = centerMapper.toCenter(centerDTO);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok", "Change or insert fresher successfully",
                        cenService.editCenter(center))
        );
    }
    @DeleteMapping("/delete/{cenCode}")
    public ResponseEntity<ResponseObject> delete(@PathVariable String cenCode) {
        cenService.deleteCenter(cenCode);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Delete fresher successfully","")
        );
    }
}