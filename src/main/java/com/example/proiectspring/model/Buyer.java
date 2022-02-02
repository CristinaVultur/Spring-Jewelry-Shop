package com.example.proiectspring.model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBuyer;
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @NotBlank(message = "Email cannot be empty")
    @Email
    private String email;


    @OneToOne
    @JoinColumn(name = "idShoppingCart")
    @JsonIgnore
    private ShoppingCart shoppingCart;

    @OneToMany(mappedBy = "buyer")
    private List<Order> orders;


    public Buyer(String name, String email, ShoppingCart shoppingCart) {
        this.name = name;
        this.email = email;
        this.shoppingCart = shoppingCart;
    }
    public Buyer(int id, String name, String email) {

        this.idBuyer = id;
        this.name = name;
        this.email = email;

    }

    public Buyer() {
    }

    public int getIdBuyer() {
        return idBuyer;
    }

    public void setIdBuyer(int idBuyer) {
        this.idBuyer = idBuyer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idBuyer +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
