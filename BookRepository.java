package com.example.readhub.readhub_backend.repository;

import com.example.readhub.readhub_backend.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByCategoryIgnoreCase(String category);
}
