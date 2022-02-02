package com.example.proiectspring.repository;

import com.example.proiectspring.model.Jewelry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JewelryRepository extends JpaRepository<Jewelry, Integer> {

    List<Jewelry> findAllByName(String name);

}
