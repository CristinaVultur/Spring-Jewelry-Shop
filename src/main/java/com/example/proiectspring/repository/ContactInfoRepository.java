package com.example.proiectspring.repository;

import com.example.proiectspring.model.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactInfoRepository extends JpaRepository<ContactInfo, Integer> {

    List<ContactInfo> findAllByCity(String city);

}
