package com.example.Controllers;

import com.example.Entity.Buyer;
import com.example.ServiceImpl.BuyerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/buyer")
public class BuyerController {

    @Autowired
    private BuyerServiceImpl buyerService;

    public BuyerController(BuyerServiceImpl buyerService) {
        this.buyerService = buyerService;
    }

    @GetMapping(value = "all")
    @ResponseStatus(HttpStatus.OK)
    public List<Buyer> getAllBuyers(){
        return buyerService.FindAll();
    }

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Buyer addBuyer(@RequestBody Buyer buyer){
        return buyerService.addBuyer(new Buyer(buyer.getSurname(), buyer.getResidenceArea(), buyer.getDiscount()));
    }

    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.OK)
    public Buyer updateBookById(@RequestParam int id, @RequestBody Buyer buyer){
        return buyerService.updateById(id, buyer);
    }

    @PutMapping(value = "update/{Id:\\d+}")
    @ResponseStatus(HttpStatus.OK)
    public Buyer updateBook(@PathVariable int Id, @RequestBody Buyer buyer){
        return buyerService.updateById(Id, buyer);
    }

    @DeleteMapping(value = "/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@RequestParam int id){
        buyerService.DeleteById(id);
    }

    @DeleteMapping(value = "delete/{Id:\\d+}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteWithoutId (@PathVariable int Id){
        buyerService.DeleteById(Id);
    }
}
