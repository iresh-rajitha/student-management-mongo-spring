package com.ireshrajitha.demo.services;

import com.ireshrajitha.demo.model.Book;
import com.ireshrajitha.demo.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public void saveBook(Book book){
        bookRepository.save(book);
    }
    public void deleteBook(int id){
        bookRepository.deleteById(id);
    }
    public List<Book> getAll(){
         return bookRepository.findAll();
    }
    public Optional<Book> getOne(int id){
        return bookRepository.findById(id);
    }
    public void updateBook(int id, Book book){
        book.setId(id);
        bookRepository.save(book);
    }

}
