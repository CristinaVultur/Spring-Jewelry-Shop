package com.example.proiectspring.service;

import com.example.proiectspring.model.*;
import com.example.proiectspring.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;
    @Mock
    private ShoppingCartService shoppingCartService;

    @Mock
    BuyerService buyerService;

    @Test
    void newOrder() {

        Jewelry jewelry = new Jewelry(1, "Nume", "Tip", 100);
        List<Jewelry> jewelryList = new ArrayList<>();
        jewelryList.add(jewelry);
        ShoppingCart shoppingCart = new ShoppingCart(1, 100, jewelryList);
        ShoppingCart empty = new ShoppingCart(1, 0, new ArrayList<>());
        Buyer buyer = new Buyer("John", "john@gmail.com", shoppingCart);
        shoppingCart.setBuyer(buyer);
        int cartId = 1;

        when(shoppingCartService.retrieveShoppingCart(cartId)).thenReturn(shoppingCart);

        when(buyerService.findById(shoppingCart.getBuyer().getIdBuyer())).thenReturn(buyer);

        when(shoppingCartService.emptyShoppingCart(shoppingCart)).thenReturn(empty);

        Order savedOrder = new Order(shoppingCart.getTotal(), OrderStatus.PROCESSED, List.copyOf(jewelryList), buyer);

        when(orderRepository.save(any(Order.class))).thenReturn(savedOrder);

        Order result = orderService.newOrder(cartId);

        assertNotNull(result);
        assertEquals(1, result.getJewelries().size());
        assertEquals(jewelry, result.getJewelries().get(0));
        assertEquals(buyer, result.getBuyer());
        assertEquals(result.getTotal(), shoppingCart.getTotal());


        verify(shoppingCartService).retrieveShoppingCart(cartId);
        verify(buyerService).findById(shoppingCart.getBuyer().getIdBuyer());
        verify(shoppingCartService).retrieveShoppingCart(cartId);
        verify(shoppingCartService).retrieveShoppingCart(cartId);

    }

    @Test
    void retrieveOrders() {

        int idBuyer = 1;
        Buyer buyer = new Buyer(1,"John", "john@gmail.com");


        Order order = new Order(100, OrderStatus.PROCESSED, List.of(), buyer);
        when(orderRepository.findAllByBuyerIdBuyer(idBuyer)).thenReturn(List.of(order));

        List<Order> result = orderService.retrieveOrders(idBuyer);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(order.getTotal(), result.get(0).getTotal());
        assertEquals(buyer, result.get(0).getBuyer());

        verify(orderRepository).findAllByBuyerIdBuyer(idBuyer);
    }
}