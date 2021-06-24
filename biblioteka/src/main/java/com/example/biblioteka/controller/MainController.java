package com.example.biblioteka.controller;

import com.example.biblioteka.model.Book;
import com.example.biblioteka.model.repo.BookRepo;
import com.example.biblioteka.services.BookService;
import com.example.biblioteka.services.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    BookRepo bookRepo;

    private final BorrowService borrowService;
    private final BookService bookService;
    @Autowired
    public MainController(BorrowService borrowService, BookService bookService, BookRepo bookRepo) {
        this.borrowService = borrowService;
        this.bookService = bookService;
        this.bookRepo = bookRepo;
    }

    @GetMapping("/")
    public String hello(){
        return "home";
    }


    @GetMapping("/list")
    public String list(Model model, Book book){
        //wyswietlenie konkretnego obiektu
        Book book0 = new Book("tytul", "autor", "typ");
        model.addAttribute("book0", book0);

        //wyswietlenie konkretnego obiektu z bazy danych o id 1
        Book book1 = bookService.getBookById(1L); // odwolanie do pierwszej ksiazki // 1L - typ Long
        model.addAttribute("book1", book1);

        //lista obiektow -> potrzebny obiekt w parametrach funkcji (Book book) oraz do modelu atrybut (books) <- <tr th:each="book : ${books}">
        model.addAttribute("books",bookRepo.findAll());
        return "list";
    }

    @GetMapping("/list/{id}")
    public String listId(Model model, @PathVariable Long id){
        return "borrow";
    }

    @GetMapping("/history")
    public String history(Model model, Book book){
        model.addAttribute("books",bookRepo.findAll());
        return "history";
    }
    @GetMapping("/history/{id}")
    public String historyId(Model model, @PathVariable Long id){
        return "historyBook";
    }

}
