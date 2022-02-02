package com.example.proiectspring.service;


import com.example.proiectspring.exception.DistributorNameNotFoundException;
import com.example.proiectspring.model.ContactInfo;
import com.example.proiectspring.model.Distributor;
import com.example.proiectspring.repository.DistributorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistributorService {


    private final DistributorRepository distributorRepository;
    private final ContactInfoService contactInfoService;

    public DistributorService(DistributorRepository distributorRepository, ContactInfoService contactInfoService) {

        this.distributorRepository = distributorRepository;
        this.contactInfoService = contactInfoService;
    }

    public List<Distributor> retrieveDistributors(String city) {
        if(city == null) {
            return distributorRepository.findAll();
        }else{
            List<ContactInfo> contactInfoList = contactInfoService.findAllByCity(city);
            List<Distributor> distributors = contactInfoList.stream().map(ContactInfo::getDistributor).collect(Collectors.toList());
            return distributors;
        }
    }
    public Distributor retrieveByName(String name) {

        Distributor distributor = distributorRepository.findByName(name).orElseThrow(() -> new DistributorNameNotFoundException());
        return distributor;
    }

}
