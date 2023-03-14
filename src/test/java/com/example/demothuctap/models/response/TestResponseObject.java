package com.example.demothuctap.models.response;

import com.example.demothuctap.models.entity.Fresher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestResponseObject {

    @Test
    void set_getStatus() {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setStatus("OK");
        assertEquals("OK",responseObject.getStatus());
    }

    @Test
    void set_getMsg() {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setMsg("thanh cong");
        assertEquals("thanh cong",responseObject.getMsg());
    }

    @Test
    void set_getData() {
        Fresher fresher = new Fresher("2019607141","Ngo Van Nguyen",
                "Ha Nam,Viet Nam","0986217059","nguyenngo@gmail.com");
        ResponseObject responseObject = new ResponseObject();
        responseObject.setData(fresher);
        assertEquals(fresher,responseObject.getData());
    }

    @Test
    void testResponseObjectConstructor(){
        ResponseObject responseObject = new ResponseObject("OK","thanh cong","data o trong nay");
        assertEquals("OK",responseObject.getStatus());
        assertEquals("thanh cong",responseObject.getMsg());
        assertEquals("data o trong nay",responseObject.getData());
    }

}