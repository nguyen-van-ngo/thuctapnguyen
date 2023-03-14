package com.example.demothuctap.service.serviceinterface;

import com.example.demothuctap.models.entity.Fresher;
import com.example.demothuctap.models.response.Transcript;

import java.util.List;

public interface FresherService {
    List<Fresher> getAllFresher();

    List<Transcript> getTranscript();

    Fresher addFresher(Fresher fresher);

    Fresher editFresher(Fresher fresher);

    void deleteFresher(String id);

    List<Fresher> searchFresherWithfresName(String fresName);

    Fresher searchFresherWithfresEmail(String fresEmail);

    List<Fresher> searchFresherWithlanguage(String language);
}
