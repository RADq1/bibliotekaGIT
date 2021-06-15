package com.example.biblioteka.services;

import com.example.biblioteka.model.Book;
import com.example.biblioteka.model.repo.BookRepo;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private final BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    //wypozyczenie ksiazki, oddanie książki, historia książki

    public Book getBookById(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()){
            return optionalBook.get();
        }
        else{
            return new Book();
        }
    }

    public void changeStatusOfBook(Book book, boolean available) {
        book.setAvailable(available);
        bookRepo.save(book);
    }

}
