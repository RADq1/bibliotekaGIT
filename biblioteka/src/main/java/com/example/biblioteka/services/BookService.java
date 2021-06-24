package com.example.biblioteka.services;

import com.example.biblioteka.model.Book;
import com.example.biblioteka.model.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    //wypozyczenie ksiazki, oddanie książki, historia książki

    //wlozenie do listy wszystkich ksiazek z repo biblioteki
    public List<Book> getAllBooks(){
        List<Book> books = bookRepo.findAll();
        return books;
    }

    //pobranie ksiazki o konkretnym id
    public Book getBookById(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()){
            return optionalBook.get();
        }
        else{
            return new Book();
        }
    }

    //zmiana statusu ksiazki
    public void changeStatusOfBook(Book book, boolean available) {
        book.setAvailable(available);
        bookRepo.save(book);
    }

}
