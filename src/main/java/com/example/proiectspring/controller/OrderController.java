package com.example.proiectspring.controller;


import com.example.proiectspring.model.Buyer;
import com.example.proiectspring.model.Order;
import com.example.proiectspring.model.ShoppingCart;
import com.example.proiectspring.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Validated
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {

        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> newOrder(@RequestParam int shoppingCartId){
        return ResponseEntity.ok().body(orderService.newOrder(shoppingCartId));

    }
    @GetMapping
    public ResponseEntity<?> retrieveOrders(@RequestParam int buyerId){
        return ResponseEntity.ok().body(orderService.retrieveOrders(buyerId));
    }

}
