package com.example.demothuctap.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "center")
public class Center {
    @Id
    @Column(name = "center_code", unique = true)
    private String cenCode;
    @Column(name = "center_name")
    private String cenName;
    @Column(name = "center_address")
    private String cenAddress;
    @Column(name = "center_phone", unique = true)
    private String cenPhone;
    @OneToMany(mappedBy = "center", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    Set<FresherCenter> fresherCenters;
}