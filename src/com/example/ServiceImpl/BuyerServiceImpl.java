package com.example.ServiceImpl;

import com.example.Entity.Buyer;
import com.example.Repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BuyerServiceImpl {

    @Autowired
    private BuyerRepository buyerRepository;

    public List<Buyer> FindAll() {
        return buyerRepository.findAll();
    }

    public Buyer findById(int id){
        return buyerRepository.findById(id).get();
    }

    public void DeleteById(int id){
        buyerRepository.deleteById(id);
    }


    public Buyer addBook(Buyer buyer) {

        Buyer savedBook = buyerRepository.saveAndFlush(buyer);
        return savedBook;
    }

    public Buyer updateById(int id, Buyer buyer){
        Buyer tmp = buyerRepository.getOne(id);
        tmp.setSurname(buyer.getSurname());
        tmp.setResidenceArea(buyer.getResidenceArea());
        tmp.setDiscount(buyer.getDiscount());
        buyerRepository.saveAndFlush(tmp);
        return tmp;
    }

}
