package com.example.demothuctap.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class User implements Serializable {
    private static final long serialVersionUID = 2405172041950251807L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "username" , nullable = false, unique = true)
    private String username;
    @Column(name = "password")
    private String password;
}
