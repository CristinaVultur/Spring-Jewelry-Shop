package com.example.proiectspring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Distributor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDistribuitor;

    @NotBlank(message =  "Name cannot be empty")
    @Column(unique = true)
    private String name;


    @OneToOne
    @JoinColumn(name = "idContactInfo")
    private ContactInfo contactInfo;

    @OneToMany(mappedBy = "distributor")
    @JsonIgnore
    private List<Jewelry> jewelries;

    public Distributor(String name, ContactInfo contactInfo){
        this.name = name;
        this.contactInfo = contactInfo;
    }
    public Distributor(int id, String name){

        this.name = name;
        this.idDistribuitor = id;
    }
    public Distributor() {
    }

    public int getIdDistribuitor() {
        return idDistribuitor;
    }

    public void setIdDistribuitor(int idDistribuitor) {
        this.idDistribuitor = idDistribuitor;
    }

    public String getName() {
        return name;
    }

    public void setName(String nume) {
        name = nume;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<Jewelry> getJewelries() {
        return jewelries;
    }

    public void setJewelries(List<Jewelry> jewelries) {
        this.jewelries = jewelries;
    }

    @Override
    public String toString() {
        return "Distributor{" +
                "idDistribuitor=" + idDistribuitor +
                ", Nume='" + name + '\'' +
                ", contactInfo=" + contactInfo +
                ", jewelries=" + jewelries +
                '}';
    }
}
