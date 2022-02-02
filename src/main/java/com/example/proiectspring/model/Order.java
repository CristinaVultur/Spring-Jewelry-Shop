package com.example.proiectspring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrder;

    @NotNull(message =  "Total cannot be empty")
    @Min(0)
    @Column
    private int total;

    @Column
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Status cannot be empty")
    private OrderStatus orderStatus;


    @ManyToMany
    private List<Jewelry> jewelries;


    @ManyToOne
    @JoinColumn(name = "idBuyer")
    @JsonIgnore
    private Buyer buyer;

    public Order(int total, OrderStatus orderStatus, List<Jewelry> jewelries, Buyer buyer) {

        this.total = total;
        this.orderStatus = orderStatus;
        this.jewelries = jewelries;
        this.buyer = buyer;
    }


    public Order() {
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus status) {
        this.orderStatus = status;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
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

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer user) {
        this.buyer = buyer;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "idOrder=" + idOrder +
                ", Total=" + total +
                ", jewelries=" + jewelries +
                '}';
    }
}
