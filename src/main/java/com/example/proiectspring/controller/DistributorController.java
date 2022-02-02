package com.example.proiectspring.controller;


import com.example.proiectspring.model.Distributor;
import com.example.proiectspring.service.DistributorService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/distributor")
@Validated
public class DistributorController {

    private final DistributorService distributorService;

    public DistributorController(DistributorService distributorService) {
        this.distributorService = distributorService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Distributor>> retrieveDistributors(@RequestParam(required = false) String city){
        return ResponseEntity.ok().body(distributorService.retrieveDistributors(city));
    }
    @GetMapping
    public ResponseEntity<Distributor> retrieveByName(@RequestParam(required =true) String name){
        return ResponseEntity.ok().body(distributorService.retrieveByName(name));
    }

}
