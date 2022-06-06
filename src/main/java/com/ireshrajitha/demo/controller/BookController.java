package com.ireshrajitha.demo.controller;

import com.ireshrajitha.demo.model.Book;
import com.ireshrajitha.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public void saveBook(@RequestBody Book book){
        bookService.saveBook(book);
    }
    @DeleteMapping
    public void deleteBook(int id){
        bookService.deleteBook(id);
    }

    @GetMapping
    public List<Book> getAll(){
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Book> getOne(@PathVariable("id") int id){
        return bookService.getOne(id);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable("id") int id , @RequestBody Book book){
        bookService.saveBook(book);
    }
}
