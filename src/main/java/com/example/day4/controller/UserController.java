package com.example.day4.controller;

import com.example.day4.entities.User;
import com.example.day4.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createSpid (@RequestBody User newUser){
        return new ResponseEntity<>(userService.createUser(newUser), HttpStatus.OK);
    }

    @PutMapping("/editUser/{id}")
    public ResponseEntity<User> editUser (@PathVariable("id") long id, @RequestBody User user){
        return new ResponseEntity<>(userService.updateUserById(id,user),HttpStatus.OK);
    }




}
