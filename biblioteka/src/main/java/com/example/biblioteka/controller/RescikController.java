package com.example.biblioteka.controller;

import com.example.biblioteka.model.Book;
import com.example.biblioteka.model.repo.BookRepo;
import com.example.biblioteka.services.BookService;
import com.example.biblioteka.services.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RescikController {

    BookRepo bookRepo;
    private final BookService bookService;
    private final BorrowService borrowService;

    @Autowired
    public RescikController(BookService bookService, BorrowService borrowService, BookRepo bookRepo) {
        this.bookService = bookService;
        this.borrowService = borrowService;
        this.bookRepo = bookRepo;
    }

    @PostMapping("/wypozycz")
    public String wypozyczenie(@RequestParam(name = "bookId") Long idBook,
                               @RequestParam(name = "userId") Long idUser){
        borrowService.borrowBook(idBook, idUser);
        return "true";
    }

    @GetMapping("/test/{id}")
    public String test(@PathVariable Long id) {
        bookService.getBookById(id);
        return "true";
    }

    @GetMapping("/zestawienie")
    public List<Book> showAllBooks() {
        return bookRepo.findAll();
    }

}
