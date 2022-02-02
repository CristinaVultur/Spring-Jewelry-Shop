package com.example.proiectspring;

import com.example.proiectspring.model.*;
import com.example.proiectspring.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProiectSpringApplication implements CommandLineRunner{

    private final ContactInfoRepository contactInfoRepository;
    private final JewelryRepository jewelryRepository;
    private final DistributorRepository distribuitorRepository;
    private final OrderRepository orderRepository;
    private final ShoppingCartRepository shoppingCartRepository;
    private final BuyerRepository buyerRepository;

    public ProiectSpringApplication(ContactInfoRepository contactInfoRepository, JewelryRepository jewelryRepository, DistributorRepository distribuitorRepository, OrderRepository orderRepository, ShoppingCartRepository shoppingCartRepository, BuyerRepository buyerRepository) {
        this.contactInfoRepository = contactInfoRepository;
        this.jewelryRepository = jewelryRepository;
        this.distribuitorRepository = distribuitorRepository;
        this.orderRepository = orderRepository;
        this.shoppingCartRepository = shoppingCartRepository;
        this.buyerRepository = buyerRepository;
    }

    public static void main(String[] args) {

        //call the repositories to populate with data

        SpringApplication.run(ProiectSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        ContactInfo contactInfo = new ContactInfo("+4752177221", "Bucuresti", "Nerva Traian", 11);
        Distributor distributor = new Distributor("Pandora", contactInfo);
        Jewelry jewelry1 = new Jewelry("Butterfly", "Chain", 20, distributor);
        Jewelry jewelry2 = new Jewelry("Flower", "Ring", 15, distributor);

        List<Jewelry> jewelryList = new ArrayList<>();
        jewelryList.add(jewelry1);
        jewelryList.add(jewelry2);

        ShoppingCart shoppingCart = new ShoppingCart(jewelry1.getPrice() +jewelry2.getPrice(), jewelryList);

        Buyer buyer = new Buyer("Cristina", "test@gmail.com", shoppingCart);
        Order order = new Order(35, OrderStatus.PROCESSED, jewelryList, buyer);
        contactInfoRepository.save(contactInfo);
        distribuitorRepository.save(distributor);
        jewelryRepository.save(jewelry1);
        jewelryRepository.save(jewelry2);
        shoppingCartRepository.save(shoppingCart);
        buyerRepository.save(buyer);

        orderRepository.save(order);

    }
}
