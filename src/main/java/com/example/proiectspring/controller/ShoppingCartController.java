package com.example.proiectspring.controller;


import com.example.proiectspring.model.Jewelry;
import com.example.proiectspring.model.ShoppingCart;
import com.example.proiectspring.service.ShoppingCartService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@Validated
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<ShoppingCart> shop(@PathVariable int cartId){
        return ResponseEntity.ok().body(shoppingCartService.retrieveShoppingCart(cartId));
    }

    @PutMapping("{cartId}/added-product/{productId}")
    public ResponseEntity<ShoppingCart> buyProduct(@PathVariable int productId, @PathVariable int cartId){
        ShoppingCart shoppingCart = shoppingCartService.buyProduct(productId, cartId);
        return ResponseEntity.ok().body(shoppingCart);
    }
    @PutMapping("{cartId}/removed-product/{productId}")
    public ResponseEntity deleteProduct(@PathVariable int productId, @PathVariable int cartId){
        ShoppingCart shoppingCart = shoppingCartService.deleteProduct(productId, cartId);
        return ResponseEntity.ok().body(shoppingCart);
    }


}
