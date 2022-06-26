package com.example.day4.service;

import com.example.day4.entities.Spid;
import com.example.day4.entities.Status;
import com.example.day4.entities.User;
import com.example.day4.repository.SpidRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SpidService {
    private SpidRepo spidRepository;

    public List<Spid> getSpidByUserId(User user) {
        return spidRepository.findSpidById(user);
    }
    @Autowired

    public Spid createSpid(@NotNull Spid spid) throws Exception {
        List<Spid> spids = spidRepository.findSpidById(spid.getUser());
        if (spids.size() > 0) {
            throw new Exception("User is already created");
        }
        spid.setUser(spid.getId());
        return spidRepository.save(spid);
    }

    public Iterable<Spid> retreiveAllSpids() {
        return spidRepository.findAll();
    }

    public Spid changeStatus(Long id, long id2) throws Exception {
        Optional<Spid> findSpid = spidRepository.findById(id);
        if (findSpid.get().getStatus().equals(Status.PENDING)) {
            findSpid.get().setStatus(Status.READY_FOR_REVIEW);
        } else throw new Exception("Status is already READY_FOR_REVIEW");
        return spidRepository.save(findSpid.get());
    }
    public Spid searchSpid(User user) throws Exception {
        List<Spid> spid = spidRepository.findSpidById(user);
        if (spid.size() <= 0) {
            throw new Exception("This Spid doesn't exists fot the selected user");
        }
        return spid.get(0);
    }

    public void deleteSpid(Spid spid) throws Exception {
        if (spid.getStatus() != Status.PENDING) {
            throw new Exception("Cant delete this Spid");
        }
        spidRepository.delete(spid);
    }

}