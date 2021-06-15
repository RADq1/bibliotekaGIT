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

    public User(String nazwa, String haslo, String email) {
        this.nazwa = nazwa;
        this.haslo = haslo;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    //TODO NIE WIEM CZY TO POWINNO BYC W TEJ TABELI
    public int getNaliczoneKary() {
        return naliczoneKary;
    }
    public void setNaliczoneKary(int naliczoneKary) {
        this.naliczoneKary = naliczoneKary;
    }


    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
