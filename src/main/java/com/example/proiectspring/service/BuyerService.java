package com.example.proiectspring.service;

import com.example.proiectspring.exception.BuyerIdNotFoundException;
import com.example.proiectspring.model.Buyer;
import com.example.proiectspring.repository.BuyerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuyerService {

    private final BuyerRepository buyerRepository;

    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    public Buyer findById(int userId) {
        return buyerRepository.findById(userId).orElseThrow(() -> new BuyerIdNotFoundException());
    }

    public Buyer save(Buyer buyer) {
        return buyerRepository.save(buyer);
    }
}
