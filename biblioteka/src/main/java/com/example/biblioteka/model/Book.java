package com.example.biblioteka.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long bookId;

    String title;
    String author;
    String type;
    boolean isAvailable = true;

    @OneToMany(mappedBy = "book")
    List<Borrow> borrow = new ArrayList<>();

    public Book() {
    }

    public Book(String title, String author, String type) {
        this.title = title;
        this.author = author;
        this.type = type;
    }
    public Book(String title, String author, String type, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.type = type;
        this.isAvailable = isAvailable;
    }

    public Book(Long bookId, String title, String author, String type, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.type = type;
        this.isAvailable = isAvailable;
    }

    public List<Borrow> getBorrow() {
        return borrow;
    }

    public void setBorrow(List<Borrow> borrow) {
        this.borrow = borrow;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
