package com.example.ServiceImpl;

import com.example.Entity.Books;
import com.example.Repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl {

    @Autowired
    private BooksRepository booksRepository;

    public List<Books> FindAll() {
        return booksRepository.findAll();
    }

    public Books findById(int id){
        return booksRepository.findById(id).get();
    }

    public void DeleteById(int id){
        booksRepository.deleteById(id);
    }


    public Books addBook(Books book) {

        Books savedBook = booksRepository.saveAndFlush(book);
        return savedBook;
    }

    public Books updateById(int id, Books book){
        Books tmp = booksRepository.getOne(id);
        tmp.setBookName(book.getBookName());
        tmp.setBookCost(book.getBookCost());
        tmp.setBookQuantity(book.getBookQuantity());
        tmp.setBookWarehouse(book.getBookWarehouse());
        booksRepository.saveAndFlush(tmp);
        return tmp;
    }

    public List<Object[]> findByCostAndNAme(){
        return booksRepository.retrieveBooksWithNameAndCost();
    }

    public void nameAndCost(){
        List<Books> tmp =  new ArrayList<>(booksRepository.findAll());
        for (Books book: tmp) {
            System.out.println(book.getBookName());
            System.out.println(book.getBookCost());
        }
    }

}
