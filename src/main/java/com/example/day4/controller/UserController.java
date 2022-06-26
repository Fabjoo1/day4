package com.example.day4.controller;

import com.example.day4.entities.User;
import com.example.day4.repository.UserRepo;
import com.example.day4.entities.Spid;
import com.example.day4.repository.SpidRepo;
import com.example.day4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<User> createSpid (@RequestBody User newUser){
        return new ResponseEntity(userService.createUser(newUser), HttpStatus.OK);
    }



}
