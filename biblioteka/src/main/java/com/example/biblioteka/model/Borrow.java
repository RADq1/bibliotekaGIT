package com.example.biblioteka.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long borrowId;

    LocalDate dataWyp;
    LocalDate dataOdd;
    LocalDate planowanaDataOdd; //TODO DODAC 3 DNI DO DATY WYPOZYCZENIA

    boolean czyOddane = false;
    int dniSpoznienia = 0;

    //TODO Wypożyczenie powinno zawierać nazwę książki oraz nazwę użytkownika
    //Wypożyczenie może mieć wiele książek, książka może mieć jedno wypożyczenie. Użytkownik może mieć wiele wypożyczeń, wypożyczenie może mieć jednego użytkownika.
    @ManyToOne
    @JoinColumn(name = "idBook")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    public Borrow() {
    }

    public Borrow(LocalDate dataWyp, LocalDate planowanaDataOdd, Book book, User user) {
        this.dataWyp = dataWyp;
        this.planowanaDataOdd = planowanaDataOdd;
        this.book = book;
        this.user = user;
    }

    public Long getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Long borrowId) {
        this.borrowId = borrowId;
    }

    public LocalDate getDataWyp() {
        return dataWyp;
    }

    public void setDataWyp(LocalDate dataWyp) {
        this.dataWyp = dataWyp;
    }

    public LocalDate getDataOdd() {
        return dataOdd;
    }

    public void setDataOdd(LocalDate dataOdd) {
        this.dataOdd = dataOdd;
    }

    public LocalDate getPlanowanaDataOdd() {
        return planowanaDataOdd;
    }

    public void setPlanowanaDataOdd(LocalDate planowanaDataOdd) {
        this.planowanaDataOdd = planowanaDataOdd;
    }

    public boolean isCzyOddane() {
        return czyOddane;
    }

    public void setCzyOddane(boolean czyOddane) {
        this.czyOddane = czyOddane;
    }

    public int getDniSpoznienia() {
        return dniSpoznienia;
    }

    public void setDniSpoznienia(int dniSpoznienia) {
        this.dniSpoznienia = dniSpoznienia;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
//Borrow - wypożyczyć