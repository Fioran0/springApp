package com.example;


import com.example.Entity.Books;
import com.example.Entity.Buyer;
import com.example.Entity.Purchase;
import com.example.Entity.Shop;
import com.example.ServiceImpl.BookServiceImpl;
import com.example.ServiceImpl.BuyerServiceImpl;
import com.example.ServiceImpl.PurchaseServiceImpl;
import com.example.ServiceImpl.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@Transactional
public class SpringBootStarter implements CommandLineRunner {



    @Autowired
    private BookServiceImpl booksService;

    @Autowired
    private PurchaseServiceImpl purchaseService;

    @Autowired
    private BuyerServiceImpl buyerService;

    @Autowired
    private ShopServiceImpl shopService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarter.class, args);
    }

    @Override
    public void run(String... args) throws Exception {



//        purchaseService.findAllp().forEach(System.out::println);
//        System.out.println(booksService.editBooks());

//        System.out.println(booksService.findById(2));

//        booksService.addBook(new Books("111", 99.00, "111", 111));
//        booksService.findByCostAndNAme().forEach(System.out::println);
//        booksService.DeleteById(11);

//        purchaseService.findAll().forEach(System.out::println);
//        purchaseService.getPurchases().forEach(System.out::println);
//        purchaseService.findAllp().forEach(System.out::println);

//        booksService.updateById(14, new Books("updated", 0.0, "updated", 0));

//        booksService.nameAndCost();

//        purchaseService.addPurchase(new Purchase(634521,
//                new Shop("Книголюб", "Нижегородский", 9.0),
//                new Buyer("Феофанов", "Советский",  9.0), 2, 999.0,
//                new Books("test", 99.0, "Gagarina", 1) ));

//        purchaseService.addPurchase(new Purchase(634521,
//                new Shop("Книголюб", "Нижегородский", 9.0),
//                new Buyer("Феофанов", "Советский",  9.0), 2, 999.0,
//                booksService.findById(2)));

//        buyerService.addBook(new Buyer("Феофанов", "Советский",  9.0)); //TO DO

//        shopService.addShop(new Shop("Книголюб", "Нижегородский", 9.0)); // TO DO

        }

    }