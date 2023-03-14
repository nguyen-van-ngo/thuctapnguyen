package com.example.demothuctap.models.testdto;

import com.example.demothuctap.models.dto.FresherDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestFresherDTO {

    @Test
    void getFresId() {
        FresherDTO fresherDTO = new FresherDTO();
        fresherDTO.setFresID("2019607141");
        assertEquals("2019607141",fresherDTO.getFresID());
    }

    @Test
    void getFresName() {
        FresherDTO fresherDTO = new FresherDTO();
        fresherDTO.setFresName("Nguyen");
        assertEquals("Nguyen",fresherDTO.getFresName());
    }

    @Test
    void set_getFresAddress() {
        FresherDTO fresherDTO = new FresherDTO();
        fresherDTO.setFresAddress("Ha Nam");
        assertEquals("Ha Nam",fresherDTO.getFresAddress());

    }

    @Test
    void set_getFresPhone() {
        FresherDTO fresherDTO = new FresherDTO();
        fresherDTO.setFresPhone("0986217059");
        assertEquals("0986217059",fresherDTO.getFresPhone());
    }

    @Test
    void set_getFresEmail() {
        FresherDTO fresherDTO = new FresherDTO();
        fresherDTO.setFresEmail("nguyenngo@gmail.com");
        assertEquals("nguyenngo@gmail.com",fresherDTO.getFresEmail());
    }

    @Test
    void testFresDTOConstructor() {
        FresherDTO fresherDTO = new FresherDTO("2019607141","Nguyen","Ha Nam",
                "0986217059","nguyenngo@gmail.com");
        assertEquals("2019607141",fresherDTO.getFresID());
        assertEquals("Nguyen",fresherDTO.getFresName());
        assertEquals("Ha Nam",fresherDTO.getFresAddress());
        assertEquals("0986217059",fresherDTO.getFresPhone());
        assertEquals("nguyenngo@gmail.com",fresherDTO.getFresEmail());
    }
}
