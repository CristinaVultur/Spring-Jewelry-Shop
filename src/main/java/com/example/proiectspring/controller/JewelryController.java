package com.example.proiectspring.controller;

import com.example.proiectspring.model.Jewelry;
import com.example.proiectspring.service.JewelryService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jewelry")
@Validated
public class JewelryController {

    private final JewelryService jewelryService;

    public JewelryController(JewelryService jewelryService) {
        this.jewelryService = jewelryService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Jewelry>> retrieveAllJewelry(@RequestParam(required = false) String name){
        return ResponseEntity.ok().body(jewelryService.retrieveAllJewelry(name));
    }
    @GetMapping("/{jewelryId}")
    public ResponseEntity<Jewelry> retrieveJewelryById(@PathVariable int jewelryId){
        return ResponseEntity.ok().body(jewelryService.retrieveJewelryById(jewelryId));
    }

}
