package com.example.biblioteka.database;

import com.example.biblioteka.model.Book;
import com.example.biblioteka.model.User;
import com.example.biblioteka.model.repo.BookRepo;
import com.example.biblioteka.model.repo.BorrowRepo;
import com.example.biblioteka.model.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class databaseInit {

    BookRepo bookRepo;
    BorrowRepo borrowRepo;
    UserRepo userRepo;
    @Autowired
    public databaseInit(BookRepo bookRepo, BorrowRepo borrowRepo, UserRepo userRepo) {
        this.bookRepo = bookRepo;
        this.borrowRepo = borrowRepo;
        this.userRepo = userRepo;
    }

    @EventListener(ApplicationReadyEvent.class) //po uruchomieniu aplikacji wywolaj ponizsza funkcje
    public void addToDatabase(){
        //books
        Book book1 = new Book("Harry potter i kamien filozoficzny", "J.K. Rowling", "Fantasy");
        Book book2 = new Book("Harry potter i komnata tajemnic", "J.K. Rowling", "Fantasy");
        Book book3 = new Book("Harry potter i komnata tajemnic", "J.K. Rowling", "Fantasy");
        Book book4 = new Book("Harry potter i wiezien azkabanu", "J.K. Rowling", "Fantasy");
        Book book5 = new Book("Harry potter i czara ognia", "J.K. Rowling", "Fantasy");
        bookRepo.save(book1);
        bookRepo.save(book2);
        bookRepo.save(book3);
        bookRepo.save(book4);
        bookRepo.save(book5);
        //users
        User user1 = new User("1998radek","12345","1998radq@gmail.com");
        User user2 = new User("radek1998","54321","1995radq@gmail.com");
        userRepo.save(user1);
        userRepo.save(user2);
        //borrows



    }

}
