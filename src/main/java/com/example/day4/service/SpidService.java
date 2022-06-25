package com.example.day4.service;


import com.example.day4.entities.Spid;
import com.example.day4.entities.Status;
import com.example.day4.entities.User;
import com.example.day4.repository.SpidRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SpidService {
    private SpidRepo spidRepository;

    public List<Spid> getSpidByUserId(User user) {
        return spidRepository.findSpidById(user);
    }

    @Transactional
    public Spid createSpid(Spid spid) throws Exception {
        List<Spid> spids = spidRepository.findSpidById(spid.getUser());
        if (spids.size() > 0) {
            throw new Exception(" This user is already created");
        }
        spid.setUser(spid.getId());
        return spidRepository.save(spid);
    }

    public Iterable<Spid> retreiveAllSpids() {
        return spidRepository.findAll();
    }

    public Spid changeSpidStatus(Spid spid) {
        spid.setStatus(Status.READY_FOR_REVIEW);
        return spidRepository.save(spid);
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
            throw new Exception("This Spid cannot be deleted");
        }
        spidRepository.delete(spid);
    }

}