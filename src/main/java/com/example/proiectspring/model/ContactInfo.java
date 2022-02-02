package com.example.proiectspring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class ContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContactInfo;

    @NotBlank(message = "Phone number cannot be null!")
    @Pattern(regexp = "(\\+4|0)[0-9]{9}")
    private String phone_number;


    @NotBlank(message =  "City cannot be empty")
    private String city;
    @NotBlank(message =  "Street cannot be empty")
    private String street;
    @NotNull(message =  "Street No. cannot be empty")
    private int streetNumber;

    @OneToOne(mappedBy = "contactInfo")
    @JsonIgnore
    private Distributor distributor;


    public ContactInfo() {
    }


    public ContactInfo(String phone_number, String city, String street, int streetNumber) {

        this.phone_number = phone_number;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
    }
    public ContactInfo(String phone_number, String city, String street, int streetNumber, Distributor distributor) {

        this.phone_number = phone_number;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
        this.distributor = distributor;
    }
    public int getIdContactInfo() {
        return idContactInfo;
    }

    public void setIdContactInfo(int idContactInfo) {
        this.idContactInfo = idContactInfo;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "idContactInfo=" + idContactInfo +
                ", phone_number='" + phone_number + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                '}';
    }
}
