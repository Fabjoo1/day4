package com.example.day4.controller;

import com.example.day4.entities.Spid;
import com.example.day4.service.SpidService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value= "/spid")
public class SpidController {
    SpidService spidService;

    SpidController(SpidService spidService){
        this.spidService = spidService;
    }

    //get spid
    @GetMapping("/spids")
    public ResponseEntity retrieveAllSpids() throws Exception {
        return (ResponseEntity<Spid>) spidService.retreiveAllSpids();
    }

    //create spid
    @PostMapping("/createSpid")
    public ResponseEntity<Spid> createSpid(@RequestBody Spid newSpid) throws Exception {
        return new ResponseEntity(spidService.createSpid(newSpid), HttpStatus.CREATED) ;
    }

    //delete spid
    @DeleteMapping("/deleteSpid/{id}")
    public ResponseEntity<Spid> deleteSpid(@PathVariable("id") long id){
        return new ResponseEntity("Spid with id : " + id + " has been deleted " , HttpStatus.OK);
    }

    //change spud
    @PutMapping("/changeSpid/{id1}{id2}")
    public ResponseEntity<Spid> changeSpid(@PathVariable("id1")long id1, @PathVariable("id2") long id2) throws Exception {
        return new ResponseEntity(spidService.changeStatus(id1,id2),HttpStatus.OK);
    }





}
