package com.example.Controllers;


import com.example.Entity.Books;
import com.example.Entity.Buyer;
import com.example.Entity.Purchase;
import com.example.Entity.Shop;
import com.example.ServiceImpl.PurchaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseServiceImpl purchaseService;

    @GetMapping(value = "all")
    @ResponseStatus(HttpStatus.OK)
    public List<Purchase> getAllPurchase(){
        return purchaseService.findAll();
    }

/*    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public Purchase addPurchase(@RequestBody Purchase purchase){
        return purchaseService.addPurchase(new Purchase(purchase.getOrderNumber(), purchase.getDate(), purchase.getSeller(),
                                            purchase.getBook(), purchase.getBuyer(), purchase.getQuantity(), purchase.getSum()));
    }*/

    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public Purchase addPurchase(@RequestBody Purchase purchase){
        return purchaseService.addPurchase(new Purchase(purchase.getOrderNumber(), purchase.getDate(),
                new Shop(purchase.getSeller().getShopName(), purchase.getSeller().getShopLocationArea(), purchase.getSeller().getCommissionFee()),
                Arrays.asList(new Books(purchase.getBook().get(0).getBookName(), purchase.getBook().get(0).getBookCost(),
                        purchase.getBook().get(0).getBookWarehouse(), purchase.getBook().get(0).getBookQuantity())),
                        new Buyer(purchase.getBuyer().getSurname(), purchase.getBuyer().getResidenceArea(), purchase.getBuyer().getDiscount()),
                        purchase.getQuantity(), purchase.getSum()));
    }


/*
    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.OK)
    public Purchase updateBookById(@RequestParam int id, @RequestBody Purchase purchase){
        return purchaseService
    }*/
}
