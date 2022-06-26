package com.example.day4.repository;

import com.example.day4.entities.Spid;
import com.example.day4.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SpidRepo extends CrudRepository<Spid, Long> {
    List<Spid> findSpidById(User user);

    Spid getReferenceById(long spidid);
}