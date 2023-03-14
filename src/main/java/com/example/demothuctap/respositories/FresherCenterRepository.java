package com.example.demothuctap.respositories;

import com.example.demothuctap.models.entity.FresherCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FresherCenterRepository extends JpaRepository<FresherCenter, Long> {
    @Query("SELECT new com.example.demothuctap.models.entity.FresherCenter" +
            "(fc.fresCenId, fc.fresher, fc.center) FROM FresherCenter fc " +
            "WHERE fc.fresher.fresID = :fresID AND fc.center.cenCode = :cenCode")
    public Optional<FresherCenter> getFresCen(String fresID, String cenCode);
}



