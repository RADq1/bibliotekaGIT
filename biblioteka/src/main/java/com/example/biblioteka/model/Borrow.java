package com.example.biblioteka.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long borrowId;

    LocalDate dataWyp;
    LocalDate dataOdd;
    LocalDate planowanaDataOdd; //TODO DODAC 3 DNI DO DATY WYPOZYCZENIA

    Boolean czyOddane = false;
    int dniSpoznienia = 0;

    //TODO Wypożyczenie powinno zawierać nazwę książki oraz nazwę użytkownika



}
//Borrow - wypożyczyć