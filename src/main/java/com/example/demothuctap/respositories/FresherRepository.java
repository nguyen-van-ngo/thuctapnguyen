package com.example.demothuctap.respositories;

import com.example.demothuctap.models.entity.Fresher;
import com.example.demothuctap.models.response.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface FresherRepository extends JpaRepository<Fresher, String> {
    @Query("SELECT new com.example.demothuctap.models.response.Transcript" +
            "(f.fresName, sb.language, sc.score01, sc.score02, sc.score03, (sc.score01+sc.score02+sc.score03)/3) " +
            "From Fresher f INNER JOIN Score sc ON sc.fresher.fresID = f.fresID INNER JOIN " +
            "Subject sb ON sb.subId = sc.subject.subId")
    public List<Transcript> getTranscript();
    @Query("SELECT new com.example.demothuctap.models.entity.Fresher" +
            "(f.fresID ,f.fresName, f.fresAddress, f.fresPhone, f.fresEmail) " +
            "From Fresher f INNER JOIN Score sc ON sc.fresher.fresID = f.fresID INNER JOIN " +
            "Subject sb ON sb.subId = sc.subject.subId " +
            "WHERE sb.language = :language")
    public List<Fresher> findByFresherWithlanguage(String language);
    public List<Fresher> findByfresName(String fresID);
    public Optional<Fresher> findByfresEmail(String fresEmail);
}
