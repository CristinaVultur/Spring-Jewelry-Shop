package com.example.proiectspring.repository;

import com.example.proiectspring.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAllByBuyerIdBuyer(int buyerId);
}
