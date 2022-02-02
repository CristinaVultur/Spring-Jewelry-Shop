package com.example.proiectspring.service;

import com.example.proiectspring.model.ContactInfo;
import com.example.proiectspring.repository.ContactInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactInfoService {

    private final ContactInfoRepository contactInfoRepository;

    public ContactInfoService(ContactInfoRepository contactInfoRepository) {
        this.contactInfoRepository = contactInfoRepository;
    }

    public List<ContactInfo> findAllByCity(String city) {

        return contactInfoRepository.findAllByCity(city);
    }
}
