package com.springboot.mongodb.repository;

import com.springboot.mongodb.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book,Long> {
    Book findBookByTitle(String title);
}
