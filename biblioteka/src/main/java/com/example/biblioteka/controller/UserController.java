package com.example.biblioteka.controller;

import com.example.biblioteka.model.repo.BookRepo;
import com.example.biblioteka.model.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    UserRepo userRepo;
    @Autowired
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }



}
