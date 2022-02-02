package com.example.proiectspring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idShoppingCart;

    @NotNull(message =  "Total cannot be empty")
    @Min(0)
    private int total;



    @OneToOne(mappedBy = "shoppingCart")
    @JsonIgnore
    private Buyer buyer;

    @ManyToMany
    @JoinTable
    private List<Jewelry> jewelries;

    public ShoppingCart(int total, List<Jewelry> jewelries) {

        this.total = total;
        this.jewelries = jewelries;

    }

    public ShoppingCart(int id, int total, List<Jewelry> jewelries) {

        this.idShoppingCart = id;
        this.total = total;
        this.jewelries = jewelries;

    }
    public ShoppingCart() {

    }


    public Buyer getBuyer() {
        return buyer;
    }
    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public int getIdShoppingCart() {
        return idShoppingCart;
    }

    public void setIdShoppingCart(int idShoppingCart) {
        this.idShoppingCart = idShoppingCart;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


    public List<Jewelry> getJewelries() {
        return jewelries;
    }

    public void setJewelries(List<Jewelry> jewelries) {
        this.jewelries = jewelries;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "idShoppingCart=" + idShoppingCart +
                ", Total=" + total +
                ", user=" + buyer +
                ", jewelries=" + jewelries +
                '}';
    }
}
