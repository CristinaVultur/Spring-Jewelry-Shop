package com.example.proiectspring.service;

import com.example.proiectspring.exception.JewelryIdNotFoundExeception;
import com.example.proiectspring.model.Jewelry;
import com.example.proiectspring.repository.JewelryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JewelryService{

    private final JewelryRepository jewelryRepository;


    public JewelryService(JewelryRepository jewelryRepository) {

        this.jewelryRepository = jewelryRepository;
    }

    public Jewelry retrieveJewelryById(int jewelryId) {

        return jewelryRepository.findById(jewelryId).orElseThrow(() -> new JewelryIdNotFoundExeception());
    }


    public List<Jewelry> retrieveAllJewelry(String name) {

        if (name == null) {
            return jewelryRepository.findAll();
        }
        else{
            return jewelryRepository.findAllByName(name);
        }
    }
}
