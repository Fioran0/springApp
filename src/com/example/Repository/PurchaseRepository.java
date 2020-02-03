package com.example.Repository;

import com.example.Entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
    @Override
    List<Purchase> findAll();

    @Override
    <S extends Purchase> S saveAndFlush(S s);

    @Override
    Purchase getOne(Integer integer);

    @Override
    void deleteById(Integer integer);


//    @Query(value = "SELECT ordernumber, name FROM shop.purchase INNER JOIN shop.shop ON purchase.seller = shop.id" , nativeQuery = true)
//    List<Object> retrievePurchaseAll();

    @Query(value = "SELECT ordernumber FROM shop.purchase" , nativeQuery = true)
    List<Object> retrievePurchaseAll();

//    @Query(value = "SELECT new Purchase(ordernumber), new Shop(name) " +
//            "FROM shop.purchase " +
//            "INNER JOIN shop.shop " +
//            "ON purchase.seller = shop.id ", nativeQuery = true)
//    List<Result> getPurchase();
}
