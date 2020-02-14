package com.example.ServiceImpl;

import com.example.Entity.Purchase;
import com.example.Repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PurchaseServiceImpl {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    public Purchase findById(int id) {
        return purchaseRepository.findById(id).get();
    }

    public void DeleteById(int id) {
        purchaseRepository.deleteById(id);
    }

    public Purchase addPurchase(Purchase purchase){
        Purchase savedPurchase = purchaseRepository.saveAndFlush(purchase);
        return savedPurchase;
    }

}
