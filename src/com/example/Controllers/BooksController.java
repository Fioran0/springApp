package com.example.Controllers;

import com.example.Entity.Books;
import com.example.ServiceImpl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BooksController {

    @Autowired
    private BookServiceImpl booksService;

    public BooksController(BookServiceImpl booksService) {
        this.booksService = booksService;
    }

    @GetMapping(value = "/{Id:\\d+}")
    public Books getBookByID(@PathVariable int Id) {
        return booksService.findById(Id);
    }

    @GetMapping(value = "/all")
    public List<Books> getAllBooks() {
        return booksService.FindAll();
    }

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Books addBook(@RequestBody Books book){
        return booksService.addBook(new Books(book.getBookName(), book.getBookCost(), book.getBookWarehouse(), book.getBookQuantity()));
    }

    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.OK)
    public Books updateBookById(@RequestParam int id, @RequestBody Books book){
        return booksService.updateById(id, book);
    }

    @PutMapping(value = "update/{Id:\\d+}")
    @ResponseStatus(HttpStatus.OK)
    public Books updateBook(@PathVariable int Id, @RequestBody Books book){
        return booksService.updateById(Id, book);
    }

    @DeleteMapping(value = "/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@RequestParam int id){
        booksService.DeleteById(id);
    }

    @DeleteMapping(value = "delete/{Id:\\d+}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteWithoutId (@PathVariable int Id){
        booksService.DeleteById(Id);
    }
}
