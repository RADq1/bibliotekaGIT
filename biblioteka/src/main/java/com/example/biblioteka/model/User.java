package com.example.biblioteka.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;
    @Column(unique = true, length = 20)
    String nazwa;
    @Column(length = 30)
    String haslo;
    @Column(unique = true, length = 30)
    String email;

    int naliczoneKary = 0;

    public User() {
    }

}
