package com.example.biblioteka.services;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import com.example.biblioteka.model.Book;
import com.example.biblioteka.model.User;
import com.example.biblioteka.model.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepo userRepo;
    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User getUserById(Long id){
        Optional<User> user = userRepo.findById(id);
        return user.get();
    }

//userRepo.findAll().stream().map(user -> user.getUserId()).
    public int naliczKareDlaOsoby(Long userId) {
        User user = getUserById(userId);

        // 0 1 2 0 3
        // 0 2 4 0 6
        // 0+2+4+0+6=12
//        return user.getBorrow().stream().map(it -> it.getDniSpoznienia()*2).reduce(0, Integer::sum);
        return user.getBorrow().stream().map(it -> it.getDniSpoznienia()).reduce(0, Integer::sum) *2;
}

    public List<Book> getBooksForUser(Long userId) {
        User user = getUserById(userId);
        return user.getBorrow().stream().map(borrow -> borrow.getBook()).collect(Collectors.toList());
    }


}
