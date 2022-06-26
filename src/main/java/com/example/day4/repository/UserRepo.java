package com.example.day4.repository;

import com.example.day4.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    List<User> findUserById(long id);

    User getReferenceById(long id);
}