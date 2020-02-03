package com.example.Repository;

import com.example.Entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {
    @Override
    List<Shop> findAll();

    @Override
    <S extends Shop> S saveAndFlush(S s);

    @Override
    Shop getOne(Integer integer);

    @Override
    void deleteById(Integer integer);
}
