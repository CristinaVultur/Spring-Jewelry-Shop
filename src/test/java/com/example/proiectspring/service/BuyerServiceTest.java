package com.example.proiectspring.service;

import com.example.proiectspring.exception.BuyerIdNotFoundException;
import com.example.proiectspring.model.Buyer;
import com.example.proiectspring.repository.BuyerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BuyerServiceTest {

    @InjectMocks
    private BuyerService buyerService;

    @Mock
    private BuyerRepository buyerRepository;


    @Test
    @DisplayName("Can't find id for buyer")
    void findByIdException() {

        int id = 1;
        //Buyer buyer = new Buyer(1, "Buyer", "buer@gmail.com");

        when(buyerRepository.findById(id)).thenReturn(Optional.empty());

        BuyerIdNotFoundException exception = assertThrows(BuyerIdNotFoundException.class,
                () -> buyerService.findById(id));

        assertNotNull(exception);
        assertEquals("Buyer Id not found.",
                exception.getMessage());
        verify(buyerRepository).findById(id);
    }

    @Test
    @DisplayName("Happy flow")
    void findById() {

        int id = 1;
        Buyer buyer = new Buyer(1, "Buyer", "buer@gmail.com");

        when(buyerRepository.findById(id)).thenReturn(Optional.of(buyer));

        Buyer result = buyerService.findById(id);

        assertNotNull(result);
        assertEquals(buyer.getIdBuyer(), result.getIdBuyer());
        assertEquals(buyer.getName(), result.getName());
        assertEquals(buyer.getEmail(), result.getEmail());

        verify(buyerRepository).findById(id);
    }

    @Test
    void save() {

        Buyer buyer = new Buyer(1, "Buyer", "buer@gmail.com");
        Buyer saved = new Buyer(1, "Buyer", "buer@gmail.com");
        when(buyerRepository.save(buyer)).thenReturn(saved);

        Buyer result = buyerService.save(buyer);

        assertNotNull(result);
        assertEquals(saved.getIdBuyer(), result.getIdBuyer());
        assertEquals(saved.getName(), result.getName());
        assertEquals(saved.getEmail(), result.getEmail());

        verify(buyerRepository).save(buyer);
    }
}