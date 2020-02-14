package com.example.ServiceImpl;

import com.example.Entity.Buyer;
import com.example.Repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
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


    public Buyer addBuyer(Buyer buyer) {

        Buyer savedBuyer = buyerRepository.saveAndFlush(buyer);
        return savedBuyer;
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
