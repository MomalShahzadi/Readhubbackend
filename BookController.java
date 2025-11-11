package com.example.readhub.readhub_backend.controller;

import com.example.readhub.readhub_backend.model.Book;
import com.example.readhub.readhub_backend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooksByCategory(@RequestParam String category) {
        List<Book> books = bookRepository.findByCategoryIgnoreCase(category);
        return ResponseEntity.ok(books);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookRepository.findAll());
    }
}
