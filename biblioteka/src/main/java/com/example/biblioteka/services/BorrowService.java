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
    //wypozyczenie książki
    public void borrowBook(Long idBook, Long idUser){
        Book book = bookService.getBookById(idBook);
        User user = userService.getUserById(idUser);
       /* sprawdzenie, czy książka jest dostępna, jeśli tak wykonaj poniższe czynności
        if(book.getAvailable())
        {
            Borrow borrow = new Borrow(LocalDate.now(), LocalDate.now().plusDays(3), book, user);
            borrowRepo.save(borrow);
            bookService.changeStatusOfBook(book, false);
        } */
        Borrow borrow = new Borrow(LocalDate.now(), LocalDate.now().plusDays(3), book, user);
        borrowRepo.save(borrow);
        bookService.changeStatusOfBook(book, false);
     }
    //wyciagniecie wypozyczenia po id
    public Borrow getBorrowById(Long id) {
        Optional<Borrow> optionalBorrow = borrowRepo.findById(id);
        if(optionalBorrow.isPresent()){ //jesli istnieje
            return optionalBorrow.get();
        }
        else{
            return new Borrow();
        }
    }
    //oddanie książki
    public void throwBook(Long borrowId) {
        Borrow borrow = getBorrowById(borrowId);
        borrow.setCzyOddane(true);
        borrow.setDataOdd(LocalDate.now());
        //RÓŻNICA POMIĘDZY DATAMI
        //if(LocalDate.now().isAfter(borrow.getPlanowanaDataOdd()) -- to samo
        if (borrow.getPlanowanaDataOdd().isBefore(LocalDate.now())) {
            //Jeśli jesteśmy spóźnieni, ustaw dni spóźnienia w liczbie int
            borrow.setDniSpoznienia((int)DAYS.between(borrow.getPlanowanaDataOdd(), LocalDate.now()));
        }
        borrowRepo.save(borrow);
        bookService.changeStatusOfBook(borrow.getBook(), true);
    }

}
