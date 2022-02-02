package com.example.proiectspring.service;

import com.example.proiectspring.model.Buyer;
import com.example.proiectspring.model.Jewelry;
import com.example.proiectspring.model.ShoppingCart;
import com.example.proiectspring.repository.ShoppingCartRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShoppingCartServiceTest {

    @InjectMocks
    private ShoppingCartService shoppingCartService;

    @Mock
    private ShoppingCartRepository shoppingCartRepository;
    @Mock
    private JewelryService jewelryService;

    @Test
    @DisplayName("Happy Flow")
    void retrieveShoppingCart() {

        int id = 1;
        ShoppingCart shoppingCart = new ShoppingCart(1,0, null);

        when(shoppingCartRepository.findById(id)).thenReturn(Optional.of(shoppingCart));

        ShoppingCart result = shoppingCartService.retrieveShoppingCart(id);

        assertNotNull(result);
        assertEquals(shoppingCart.getIdShoppingCart(), result.getIdShoppingCart());

        verify(shoppingCartRepository).findById(id);

    }

    @Test
    @DisplayName("Happy flow.")
    void buyProduct() {

        int cartId = 1;
        int productId = 1;
        List<Jewelry> jewelryList = new ArrayList<>();
        ShoppingCart shoppingCart = new ShoppingCart(1, 0, jewelryList);
        when(shoppingCartRepository.findById(cartId)).thenReturn(Optional.of(shoppingCart));

        Jewelry jewelry = new Jewelry(1, "Nume", "Tip", 100);
        when(jewelryService.retrieveJewelryById(productId)).thenReturn(jewelry);

        ShoppingCart newCart = new ShoppingCart(1, 100, List.of(jewelry));
        when(shoppingCartRepository.save(shoppingCart)).thenReturn(newCart);

        ShoppingCart result = shoppingCartService.buyProduct(productId, cartId);

        assertNotNull(result);
        assertEquals(1, result.getJewelries().size());
        assertEquals(jewelry, result.getJewelries().get(0));
        assertEquals(newCart.getTotal(), result.getTotal());
        assertEquals(newCart.getIdShoppingCart(), result.getIdShoppingCart());


        verify(jewelryService).retrieveJewelryById(productId);
        verify(shoppingCartRepository).findById(cartId);


    }

    @Test
    @DisplayName("Happy Flow")
    void deleteProduct() {
        int cartId = 1;
        int productId = 1;
        Jewelry jewelry = new Jewelry(1, "Nume", "Tip", 100);
        List<Jewelry> jewelryList = new ArrayList<>();
        jewelryList.add(jewelry);
        ShoppingCart shoppingCart = new ShoppingCart(1, 100, jewelryList);
        when(shoppingCartRepository.findById(cartId)).thenReturn(Optional.of(shoppingCart));

        when(jewelryService.retrieveJewelryById(productId)).thenReturn(jewelry);

        jewelryList.remove(jewelry);
        ShoppingCart newCart = new ShoppingCart(1, 0, jewelryList);
        when(shoppingCartRepository.save(shoppingCart)).thenReturn(newCart);

        ShoppingCart result = shoppingCartService.deleteProduct(productId, cartId);

        assertNotNull(result);
        assertEquals(0, result.getJewelries().size());
        assertEquals(newCart.getTotal(), result.getTotal());
        assertEquals(newCart.getIdShoppingCart(), result.getIdShoppingCart());


        verify(jewelryService).retrieveJewelryById(productId);
        verify(shoppingCartRepository).findById(cartId);
    }

    @Test
    @DisplayName("Happy Flow")
    void emptyShoppingCart() {

        Jewelry jewelry = new Jewelry(1, "Nume", "Tip", 100);
        List<Jewelry> jewelryList = new ArrayList<>();
        jewelryList.add(jewelry);
        ShoppingCart shoppingCart = new ShoppingCart(1, 100, jewelryList);

        jewelryList.remove(jewelry);
        ShoppingCart newCart = new ShoppingCart(1, 0, jewelryList);

        when(shoppingCartRepository.save(shoppingCart)).thenReturn(newCart);

        ShoppingCart result = shoppingCartService.emptyShoppingCart(shoppingCart);

        assertNotNull(result);
        assertEquals(0, result.getJewelries().size());
        assertEquals(newCart.getTotal(), result.getTotal());
        assertEquals(newCart.getIdShoppingCart(), result.getIdShoppingCart());

        verify(shoppingCartRepository).save(shoppingCart);


    }



}