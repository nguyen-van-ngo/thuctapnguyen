package com.example.demothuctap.respositories;

import com.example.demothuctap.models.entity.Fresher;
import com.example.demothuctap.models.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    @Query("SELECT new com.example.demothuctap.models.entity.Score" +
            "(sc.scoreId, sc.score01, sc.score02, sc.score03, sc.fresher, sc.subject) " +
            "FROM Score sc WHERE sc.fresher.fresID = :fresID AND sc.subject.subId = :subId")
    public Optional<Score> getScore(String fresID, String subId);
    @Query("SELECT new com.example.demothuctap.models.entity.Fresher" +
            "(f.fresID, f.fresName, f.fresAddress, f.fresPhone, f.fresEmail) " +
            "FROM Fresher f INNER JOIN Score sc ON sc.fresher.fresID = f.fresID " +
            "GROUP BY f.fresID, sc.score01, sc.score02, sc.score03 " +
            "HAVING (sc.score01+ sc.score02+ sc.score03)/3.0 = :average")
    public List<Fresher>findFresherByScore(Double average);

}