package com.example.Repository;

import com.example.Entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Integer> {

    @Override
    List<Buyer> findAll();

    @Override
    <S extends Buyer> S saveAndFlush(S s);

    @Override
    Buyer getOne(Integer integer);

    @Override
    void deleteById(Integer integer);

//    @Query(value = "SELECT name, cost FROM shop.books" , nativeQuery = true)
//    List<Object[]> retrieveBooksWithNameAndCost();
}
