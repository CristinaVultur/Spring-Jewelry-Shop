package com.example.proiectspring.repository;

import com.example.proiectspring.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

    Optional<ShoppingCart> findShoppingCartByBuyerIdBuyer(int buyerId);


}
