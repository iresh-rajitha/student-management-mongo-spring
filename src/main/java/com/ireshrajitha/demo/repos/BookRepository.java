package com.ireshrajitha.demo.repos;

import com.ireshrajitha.demo.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, Integer> {
}
