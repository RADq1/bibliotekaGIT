package com.example.biblioteka.controller;

import com.example.biblioteka.model.Book;
import com.example.biblioteka.model.Borrow;
import com.example.biblioteka.model.repo.BookRepo;
import com.example.biblioteka.services.BookService;
import com.example.biblioteka.services.BorrowService;
import com.example.biblioteka.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RescikController {

    BookRepo bookRepo;
    private final BookService bookService;
    private final BorrowService borrowService;
    private final UserService userService;

    @Autowired
    public RescikController(BookService bookService, BorrowService borrowService, BookRepo bookRepo, UserService userService) {
        this.bookService = bookService;
        this.borrowService = borrowService;
        this.bookRepo = bookRepo;
        this.userService = userService;
    }

    //http://localhost:8080/wypozycz?bookId=3&userId=2
    @PostMapping("/wypozycz")
    public String wypozyczenie(@RequestParam(name = "bookId") Long idBook,
                               @RequestParam(name = "userId") Long idUser){
        Book book = bookService.getBookById(idBook);
        //sprawdzenie, czy książka jest dostępna, jeśli tak wykonaj poniższe czynności
        if(book.getAvailable())
        {
            borrowService.borrowBook(idBook, idUser);
            return "true";
        }
        return "false";

    }
    //http://localhost:8080/oddaj?borrowId=1
    @PostMapping("/oddaj")
    public String oddanie(@RequestParam(name = "borrowId") Long idBorrow){
        Borrow borrow = borrowService.getBorrowById(idBorrow);
        if(borrow.isCzyOddane() == false){
            borrowService.throwBook(idBorrow);
            return "true";
        }
        return "false";

    }
    @GetMapping("/test/{id}")
    public String test(@PathVariable Long id) {
        bookService.getBookById(id);
        return "true";
    }

    //zestawienie, lista wszystkich książek
    @GetMapping("/zestawienie")
    public List<Book> showAllBooks() {
        return bookRepo.findAll();
    }

    //kara dla konkretnego użytkownika
    @GetMapping("/kara/{id}")
    public String karaDlaKonkretnegoUseraPoID(@PathVariable Long id){
        userService.naliczKareDlaOsoby(id);
        return "true";
    }

}
