package com.example.demothuctap.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fresher")
public class Fresher {
    @Id
    @Column(name = "fresher_id", unique = true)
    private String fresID;
    @Column(name = "fresher_name")
    private String fresName;
    @Column(name = "fresher_address")
    private String fresAddress;
    @Column(name = "fresher_phone", unique = true)
    private String fresPhone;
    @Column(name = "fresher_email", unique = true)
    private String fresEmail;

    @OneToMany(mappedBy = "fresher", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    Set<FresherCenter> fresherCenters;
    @OneToMany(mappedBy = "fresher", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    Set<Score> scores;

    public Fresher(String fresID, String fresName, String fresAddress, String fresPhone, String fresEmail) {
        this.fresID = fresID;
        this.fresName = fresName;
        this.fresAddress = fresAddress;
        this.fresPhone = fresPhone;
        this.fresEmail = fresEmail;
    }
}