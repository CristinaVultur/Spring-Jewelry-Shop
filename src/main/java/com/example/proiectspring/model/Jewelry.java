package com.example.proiectspring.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Jewelry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idJewelry;
    @NotBlank(message =  "Name cannot be empty")
    private String name;
    @NotBlank(message =  "Type cannot be empty")
    private String type;
    @NotNull(message = "Price cannort be empty")
    @Min(1)
    private int price;


    @ManyToOne
    @JoinColumn(name = "idDistributor")
    private Distributor distributor;

    public Jewelry() {

    }

    public Jewelry(String name, String type, int price, Distributor distributor) {

        this.name = name;
        this.type = type;
        this.price = price;
        this.distributor = distributor;
    }
    public Jewelry(int id, String name, String type, int price) {

        this.idJewelry = id;
        this.name = name;
        this.type = type;
        this.price = price;

    }




    public int getIdJewelry() {
        return idJewelry;
    }

    public void setIdJewelry(int idJewelry) {
        this.idJewelry = idJewelry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

    @Override
    public String toString() {
        return "Jewelry{" +
                "idJewelry=" + idJewelry +
                ", Name='" + name + '\'' +
                ", Type='" + type + '\'' +
                ", Price=" + price +

                ", distributor=" + distributor +
                '}';
    }
}
