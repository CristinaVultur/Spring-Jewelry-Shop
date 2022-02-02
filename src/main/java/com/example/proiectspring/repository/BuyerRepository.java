package com.example.proiectspring.repository;

import com.example.proiectspring.model.Buyer;
import com.example.proiectspring.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuyerRepository extends JpaRepository<Buyer, Integer> {
}
