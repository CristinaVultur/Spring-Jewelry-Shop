package com.example.proiectspring.service;

import com.example.proiectspring.model.ContactInfo;
import com.example.proiectspring.repository.ContactInfoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ContactInfoServiceTest {

    @InjectMocks
    private ContactInfoService contactInfoService;

    @Mock
    private ContactInfoRepository contactInfoRepository;

    @Test
    @DisplayName("Find Contact Info by City.")
    void findAllByCity() {

        String city = "Suceava";
        ContactInfo contactInfo = new ContactInfo("0752177221","Suceava", "Mihai", 15);

        when(contactInfoRepository.findAllByCity(city)).thenReturn(List.of(contactInfo));

        List<ContactInfo> result = contactInfoService.findAllByCity(city);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(contactInfo, result.get(0));


        verify(contactInfoRepository).findAllByCity(city);
    }
}