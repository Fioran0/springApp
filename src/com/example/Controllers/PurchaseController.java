package com.example.Controllers;


import com.example.Entity.Purchase;
import com.example.ServiceImpl.PurchaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
}
