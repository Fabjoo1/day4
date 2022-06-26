package com.example.day4.service;

import com.example.day4.entities.User;
import com.example.day4.repository.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepository;

    public UserService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    public User updateUserById(long id,User user){
        User userToBeEdited=userRepository.getReferenceById(id);
        if(userToBeEdited==null) return null;
        userToBeEdited=user;
        userToBeEdited.setId(id);
        return userRepository.save(userToBeEdited);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}