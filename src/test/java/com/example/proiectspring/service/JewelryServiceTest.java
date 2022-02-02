package com.example.proiectspring.service;

import com.example.proiectspring.model.ContactInfo;
import com.example.proiectspring.model.Jewelry;
import com.example.proiectspring.repository.JewelryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class JewelryServiceTest {

    @InjectMocks
    private JewelryService jewelryService;

    @Mock
    private JewelryRepository jewelryRepository;

    @Test
    @DisplayName("Happy flow")
    void retrieveJewelryTest(){

        //arrange
        int idJewelry = 1;
        Jewelry jewelry = new Jewelry(1,"Name1", "Type1", 100);
        when(jewelryRepository.findById(idJewelry)).thenReturn(Optional.of(jewelry));
        //act
        Jewelry result = jewelryService.retrieveJewelryById(idJewelry);

        //assert
        assertNotNull(result);
        assertEquals(jewelry.getIdJewelry(), result.getIdJewelry());
        assertEquals(jewelry.getName(), result.getName());
        assertEquals(jewelry.getType(), result.getType());
        assertEquals(jewelry.getPrice(), result.getPrice());

        verify(jewelryRepository).findById(idJewelry);
    }


    @Test
    @DisplayName("Show jewelries by name")
    void retrieveAllJewelryByName() {
        //arrange
        String name = "NumeTest";
        Jewelry jewelry = new Jewelry(1, "NumeTest", "Type1", 100);
        when(jewelryRepository.findAllByName(name)).thenReturn(List.of(jewelry));

        //act
        List<Jewelry> result = jewelryService.retrieveAllJewelry(name);

        //assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(jewelry, result.get(0));

        verify(jewelryRepository).findAllByName(name);
        verify(jewelryRepository, never()).findAll();

    }
    @Test
    @DisplayName("Show all jewelries")
    void retrieveAll() {
        //arrange
        String name = null;
        Jewelry jewelry = new Jewelry(1, "NumeTest", "Type1", 100);
        when(jewelryRepository.findAll()).thenReturn(List.of(jewelry));

        //act
        List<Jewelry> result = jewelryService.retrieveAllJewelry(name);

        //assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(jewelry, result.get(0));

        verify(jewelryRepository).findAll();
        verify(jewelryRepository, never()).findAllByName(name);

    }


}
