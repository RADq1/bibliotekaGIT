package com.example.biblioteka.controller;

import com.example.biblioteka.model.Book;
import com.example.biblioteka.model.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.metrics.ApplicationStartup;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    BookRepo bookRepo;
    @Autowired
    public BookController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @EventListener(ApplicationReadyEvent.class) //po uruchomieniu aplikacji wywolaj ponizsza funkcje
    public void addBooksToDatabase(){
        Book book1 = new Book("Harry potter i kamien filozoficzny", "J.K. Rowling", "Fantasy");
        Book book2 = new Book("Harry potter i komnata tajemnic", "J.K. Rowling", "Fantasy");
        Book book3 = new Book("Harry potter i komnata tajemnic", "J.K. Rowling", "Fantasy");
        Book book4 = new Book("Harry potter i wiezien azkabanu", "J.K. Rowling", "Fantasy");

        bookRepo.save(book1);
        bookRepo.save(book2);
        bookRepo.save(book3);
        bookRepo.save(book4);


    }

}
