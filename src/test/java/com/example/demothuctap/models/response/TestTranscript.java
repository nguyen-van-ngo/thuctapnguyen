package com.example.demothuctap.models.response;

import com.example.demothuctap.models.entity.Fresher;
import com.example.demothuctap.models.entity.Score;
import com.example.demothuctap.models.entity.Subject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTranscript {

    @Test
    void set_getFresName() {
        Transcript transcript = new Transcript();
        transcript.setFresName("Nguyễn Duc Huan");
        assertEquals("Nguyễn Duc Huan",transcript.getFresName());
    }

    @Test
    void set_getLanguage() {
        Transcript transcript = new Transcript();
        transcript.setLanguage("JAVA");
        assertEquals("JAVA",transcript.getLanguage());
    }

    @Test
    void set_getScore01() {
        Transcript transcript = new Transcript();
        transcript.setScore01(7.7);
        assertEquals(7.7,transcript.getScore01());
    }

    @Test
    void set_getScore02() {
        Transcript transcript = new Transcript();
        transcript.setScore02(9d);
        assertEquals(9d,transcript.getScore02());
    }

    @Test
    void set_getScore03() {
        Transcript transcript = new Transcript();
        transcript.setScore03(8d);
        assertEquals(8d,transcript.getScore03());
    }

    @Test
    void set_getAverage() {
        Transcript transcript = new Transcript();
        transcript.setAverage(7.5);
        assertEquals(7.5,transcript.getAverage());
    }

    @Test
    void testTranscriptConstructor() {
        Transcript transcript = new Transcript("Nguyễn Duc Huan","PYTHON",
                6d,5d,5.5,7.5);
        assertEquals("Nguyễn Duc Huan",transcript.getFresName());
        assertEquals("PYTHON",transcript.getLanguage());
        assertEquals(6d,transcript.getScore01());
        assertEquals(5d,transcript.getScore02());
        assertEquals(5.5,transcript.getScore03());
        assertEquals(7.5,transcript.getAverage());
    }
    @Test
    void testTranscriptConstructorExtendsScore(){
        Fresher fresher = new Fresher("","Alice","","","");
        Subject subject = new Subject("","JAVA",null);
        Score score = new Score(1L,8d,8d,9d,fresher,subject);
        Transcript transcript = new Transcript(score);
        assertEquals(8d,transcript.getScore01());
        assertEquals(8d,transcript.getScore02());
        assertEquals(9d,transcript.getScore03());
        assertEquals("Alice",transcript.getFresName());
        assertEquals("JAVA",transcript.getLanguage());
    }
}