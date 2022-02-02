package com.example.proiectspring.service;


import com.example.proiectspring.exception.BuyerIdNotFoundException;
import com.example.proiectspring.exception.CartIdNotFoundException;
import com.example.proiectspring.exception.JewelryIdNotFoundExeception;
import com.example.proiectspring.model.Buyer;
import com.example.proiectspring.model.Jewelry;
import com.example.proiectspring.model.ShoppingCart;
import com.example.proiectspring.repository.BuyerRepository;
import com.example.proiectspring.repository.JewelryRepository;
import com.example.proiectspring.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {


    private final ShoppingCartRepository shoppingCartRepository;
    private final JewelryService jewelryService;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, JewelryService jewelryService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.jewelryService = jewelryService;

    }

    public ShoppingCart retrieveShoppingCart(int cartId) {

        return shoppingCartRepository.findById(cartId).orElseThrow(() -> new CartIdNotFoundException());
    }

    public ShoppingCart buyProduct(int productId, int cartId){

            ShoppingCart shoppingCart = shoppingCartRepository.findById(cartId)
                    .orElseThrow(() -> new CartIdNotFoundException());
            Jewelry product = jewelryService.retrieveJewelryById(productId);
            int price = product.getPrice();
            List<Jewelry> jewelries = shoppingCart.getJewelries();
            jewelries.add(product);
            int total = shoppingCart.getTotal() + price;
            shoppingCart.setJewelries(jewelries);
            shoppingCart.setTotal(total);
            return shoppingCartRepository.save(shoppingCart);
    }

    public ShoppingCart deleteProduct(int productId, int cartId) {

        ShoppingCart shoppingCart = shoppingCartRepository.findById(cartId)
                .orElseThrow(() -> new CartIdNotFoundException());

        Jewelry product = jewelryService.retrieveJewelryById(productId);

        List<Jewelry> jewelries = shoppingCart.getJewelries();
        jewelries.remove(product);
        int total = shoppingCart.getTotal() - product.getPrice();
        shoppingCart.setJewelries(jewelries);
        shoppingCart.setTotal(total);
        return shoppingCartRepository.save(shoppingCart);



    }

    public ShoppingCart emptyShoppingCart(ShoppingCart shoppingCart) {

        List<Jewelry> jewelries = shoppingCart.getJewelries();
        jewelries.removeAll(jewelries);
        shoppingCart.setJewelries(jewelries);
        shoppingCart.setTotal(0);
        return shoppingCartRepository.save(shoppingCart);
    }
}
