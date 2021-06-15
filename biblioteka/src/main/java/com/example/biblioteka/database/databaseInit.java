package com.example.biblioteka.database;

import com.example.biblioteka.model.Book;
import com.example.biblioteka.model.Borrow;
import com.example.biblioteka.model.User;
import com.example.biblioteka.model.repo.BookRepo;
import com.example.biblioteka.model.repo.BorrowRepo;
import com.example.biblioteka.model.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;

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
        Book book1 = new Book("Harry potter i kamien filozoficzny", "J.K. Rowling", "Fantasy", false);
        Book book2 = new Book("Harry potter i komnata tajemnic", "J.K. Rowling", "Fantasy", false);
        Book book3 = new Book("Harry potter i komnata tajemnic", "J.K. Rowling", "Fantasy");
        Book book4 = new Book("Harry potter i wiezien azkabanu", "J.K. Rowling", "Fantasy", false);
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
        LocalDate data1 = LocalDate.now().minusDays(10);
        LocalDate data2 = LocalDate.now().minusDays(5);
        LocalDate data3 = LocalDate.now().minusDays(2);
        Borrow borrow1 = new Borrow(data1, data1.plusDays(3), book1, user1);
        Borrow borrow2 = new Borrow(data2, data2.plusDays(3), book2, user1);
        Borrow borrow3 = new Borrow(data3, data3.plusDays(3), book4, user2);
        borrowRepo.save(borrow1);
        borrowRepo.save(borrow2);
        borrowRepo.save(borrow3);
    }

}
