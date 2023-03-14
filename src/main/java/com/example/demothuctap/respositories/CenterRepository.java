package com.example.demothuctap.respositories;

import com.example.demothuctap.models.entity.Center;
import com.example.demothuctap.models.entity.Fresher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CenterRepository extends JpaRepository<Center, String> {
    @Query("SELECT new com.example.demothuctap.models.entity.Fresher" +
            "(f.fresID ,f.fresName, f.fresAddress, f.fresPhone, f.fresEmail) " +
            "From Fresher f INNER JOIN FresherCenter fc ON fc.fresher.fresID = f.fresID INNER JOIN " +
            "Center ce ON ce.cenCode = fc.center.cenCode " +
            "WHERE ce.cenCode = :cenCode")
    public List<Fresher> getFresOfCen(String cenCode);
    public List<Center> findBycenCode(String cenCode);
}
