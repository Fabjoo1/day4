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

    public User updateUserById(long id, String name, String surname, String email) throws Exception {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new Exception("User does not exist");
        }
            user.get().setName(name);
            user.get().setSurname(surname);
            user.get().setEmail(email);
            return userRepository.save(user.get());
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}