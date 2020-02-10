package com.example.Controllers;


import com.example.Entity.Shop;
import com.example.ServiceImpl.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/shop")
public class ShopController {

    @Autowired
    private ShopServiceImpl shopService;

    public ShopController(ShopServiceImpl shopService) {
        this.shopService = shopService;
    }

    @GetMapping(value = "all")
    @ResponseStatus(HttpStatus.OK)
    public List<Shop> getAllShops(){
        return shopService.FindAll();
    }

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Shop addShop(@RequestBody Shop shop){
        return shopService.addShop(new Shop(shop.getShopName(), shop.getShopLocationArea(), shop.getCommissionFee()));
    }

    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.OK)
    public Shop updateBookById(@RequestParam int id, @RequestBody Shop shop){
        return shopService.updateById(id, shop);
    }

    @PutMapping(value = "update/{Id:\\d+}")
    @ResponseStatus(HttpStatus.OK)
    public Shop updateBook(@PathVariable int Id, @RequestBody Shop shop){
        return shopService.updateById(Id, shop);
    }

    @DeleteMapping(value = "/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@RequestParam int id){
        shopService.DeleteById(id);
    }

    @DeleteMapping(value = "delete/{Id:\\d+}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteWithoutId (@PathVariable int Id){
        shopService.DeleteById(Id);
    }

}

