package com.example.proiectspring.service;

import com.example.proiectspring.model.ContactInfo;
import com.example.proiectspring.model.Distributor;
import com.example.proiectspring.repository.DistributorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DistributorServiceTest {

    @InjectMocks
    private DistributorService distribuitorService;

    @Mock
    private DistributorRepository distributorRepository;
    @Mock
    private ContactInfoService contactInfoService;

    @Test
    @DisplayName("Show all distributors")
    void retrieveAllDistributors() {

        Distributor distributor = new Distributor(1, "Nume");
        when(distributorRepository.findAll()).thenReturn(List.of(distributor));

        //act
        List<Distributor> result = distribuitorService.retrieveDistributors(null);

        //assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(distributor, result.get(0));

        verify(contactInfoService, never()).findAllByCity(any());
        verify(distributorRepository).findAll();

    }
    @Test
    @DisplayName("Show distribuitor from city")
    void retrieveDistributorsByCity() {

        String city = "Suceava";
        Distributor distributor = new Distributor(1,"Nume");

        ContactInfo contactInfo = new ContactInfo("0752177221","Suceava", "Mihai", 15, distributor);

        when(contactInfoService.findAllByCity(city)).thenReturn(List.of(contactInfo));


        //act
        List<Distributor> result = distribuitorService.retrieveDistributors(city);

        //assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(distributor, result.get(0));

        verify(contactInfoService).findAllByCity(city);
        verify(distributorRepository, never()).findAll();
    }

    @Test
    void retrieveByName() {

        String name = "Nume";
        Distributor distributor = new Distributor(1,"Nume");

        when(distributorRepository.findByName(name)).thenReturn(Optional.of(distributor));

        Distributor result = distribuitorService.retrieveByName(name);


        assertNotNull(result);
        assertEquals(distributor.getIdDistribuitor(), result.getIdDistribuitor());
        assertEquals(distributor.getName(), result.getName());

        verify(distributorRepository).findByName(name);
    }
}
