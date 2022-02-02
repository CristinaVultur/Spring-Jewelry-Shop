package com.example.proiectspring.service;

import com.example.proiectspring.model.*;
import com.example.proiectspring.repository.BuyerRepository;
import com.example.proiectspring.repository.OrderRepository;
import com.example.proiectspring.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ShoppingCartService shoppingCartService;
    private final BuyerService buyerService;


    public OrderService(OrderRepository orderRepository, ShoppingCartService shoppingCartService, BuyerService buyerService) {
        this.orderRepository = orderRepository;
        this.shoppingCartService = shoppingCartService;
        this.buyerService = buyerService;
    }

    public Order newOrder(int shoppingCartId) {

        ShoppingCart shoppingCart = shoppingCartService.retrieveShoppingCart(shoppingCartId);

        Buyer buyer = buyerService.findById(shoppingCart.getBuyer().getIdBuyer());
        List<Jewelry> jewelries = shoppingCart.getJewelries();

        Order order = new Order(shoppingCart.getTotal(), OrderStatus.PROCESSED, (List.copyOf(jewelries)), buyer);

        shoppingCartService.emptyShoppingCart(shoppingCart);

        orderRepository.save(order);

        return order;
    }

    public List<Order> retrieveOrders(int buyerId) {
        return orderRepository.findAllByBuyerIdBuyer(buyerId);
    }
}
