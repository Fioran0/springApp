package com.example.Repository;

import com.example.Entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {
    @Override
    List<Books> findAll();

    @Override
    <S extends Books> S saveAndFlush(S s);

    @Override
    Books getOne(Integer integer);

    @Override
    void deleteById(Integer integer);

    @Query(value = "SELECT name, cost FROM shop.books" , nativeQuery = true)
    List<Object[]> retrieveBooksWithNameAndCost();
}
