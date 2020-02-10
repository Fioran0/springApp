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
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
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

/*       Purchase purchase = new Purchase();

        purchase.setOrderNumber(524624);
        purchase.setDate(new Date(119,11,11));
        purchase.setQuantity(145);
        purchase.setSum(1111.0);

        Buyer buyer = new Buyer();
//        buyer.setId(0);
        buyer.setSurname("surname");
        buyer.setDiscount(11.9);
        buyer.setResidenceArea("residence");
        purchase.setBuyer(buyer);

        Shop shop = new Shop();
//        shop.setId(0);
        shop.setShopName("test");
        shop.setShopLocationArea("asdfads");
        shop.setCommissionFee(11.9);
        purchase.setSeller(shop);

        Books books = new Books();
        books.setBookName("testname");
        books.setBookCost(111.0);
        books.setBookQuantity(11);
        books.setBookWarehouse("adfgadf");
        purchase.setBook(Arrays.asList(books));
        purchaseService.addPurchase(purchase);*/

/*        purchaseService.addPurchase(new Purchase(634521, new Date(119,11,15),
                new Shop("Книголюб", "Нижегородский", 9.0),
                Arrays.asList(new Books("test", 99.0, "Gagarina", 1)),
                new Buyer("Феофанов", "Советский",  9.0), 2,999.0 ));*/

//        purchaseService.addPurchase(new Purchase(634521,
//                new Shop("Книголюб", "Нижегородский", 9.0),
//                new Buyer("Феофанов", "Советский",  9.0), 2, 999.0,
//                booksService.findById(2)));

//        buyerService.addBuyer(new Buyer("Феофанов", "Советский",  9.0));

//        shopService.addShop(new Shop("Книголюбы", "Нижегородский", 9.0));

//        booksService.addBook(new Books("test", 111.0, "test", 0));


        }

    }