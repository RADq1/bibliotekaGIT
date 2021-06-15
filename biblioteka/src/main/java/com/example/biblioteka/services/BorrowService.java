package com.example.biblioteka.services;

import com.example.biblioteka.model.Book;
import com.example.biblioteka.model.Borrow;
import com.example.biblioteka.model.User;
import com.example.biblioteka.model.repo.BorrowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class BorrowService {

    private final BorrowRepo borrowRepo;
    private final BookService bookService;
    private final UserService userService;
    @Autowired
    public BorrowService(BorrowRepo borrowRepo, BookService bookService, UserService userService) {
        this.borrowRepo = borrowRepo;
        this.bookService = bookService;
        this.userService = userService;
    }

    public void borrowBook(Long idBook, Long idUser){
        Book book = bookService.getBookById(idBook);
        User user = userService.getUserById(idUser);
        Borrow borrow = new Borrow(LocalDate.now(), LocalDate.now().plusDays(3), book, user);
        borrowRepo.save(borrow);
        bookService.changeStatusOfBook(book, false);
     }

    public Borrow getBorrowById(Long id) {
        Optional<Borrow> optionalBorrow = borrowRepo.findById(id);
        if(optionalBorrow.isPresent()){
            return optionalBorrow.get();
        }
        else{
            return new Borrow();
        }
    }

    public void throwBook(Long borrowId) {
        Borrow borrow = getBorrowById(borrowId);
        borrow.setCzyOddane(true);
        borrow.setDataOdd(LocalDate.now());
        if (borrow.getPlanowanaDataOdd().isBefore(LocalDate.now())) {
            borrow.setDniSpoznienia((int)DAYS.between(borrow.getPlanowanaDataOdd(), LocalDate.now()));
        }
        borrowRepo.save(borrow);
        bookService.changeStatusOfBook(borrow.getBook(), true);
    }




}
