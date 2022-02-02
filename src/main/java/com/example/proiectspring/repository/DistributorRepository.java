package com.example.proiectspring.repository;

import com.example.proiectspring.model.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DistributorRepository extends JpaRepository<Distributor, Integer> {

    Optional<Distributor> findByName(String name);
}
