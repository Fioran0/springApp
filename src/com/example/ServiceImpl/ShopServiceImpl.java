package com.example.ServiceImpl;

import com.example.Entity.Shop;
import com.example.Repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ShopServiceImpl {
    @Autowired
    private ShopRepository shopRepository;

    public List<Shop> FindAll() {
        return shopRepository.findAll();
    }

    public Shop findById(int id){
        return shopRepository.findById(id).get();
    }

    public void DeleteById(int id){
        shopRepository.deleteById(id);
    }


    public Shop addShop(Shop shop) {

        Shop savedBook = shopRepository.saveAndFlush(shop);
        return savedBook;
    }

    public Shop updateById(int id, Shop shop){
        Shop tmp = shopRepository.getOne(id);
        tmp.setShopName(shop.getShopName());
        tmp.setShopLocationArea(shop.getShopLocationArea());
        tmp.setCommissionFee(shop.getCommissionFee());
        shopRepository.saveAndFlush(tmp);
        return tmp;
    }
}
