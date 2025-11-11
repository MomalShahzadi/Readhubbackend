package com.example.readhub.readhub_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
public class Book {

    @Id
    private String id;
    private String title;
    private String author;
    private String coverUrl;
    private String category;

    public Book() {}

    public Book(String title, String author, String coverUrl, String category) {
        this.title = title;
        this.author = author;
        this.coverUrl = coverUrl;
        this.category = category;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCoverUrl() { return coverUrl; }
    public String getCategory() { return category; }

    public void setId(String id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setCoverUrl(String coverUrl) { this.coverUrl = coverUrl; }
    public void setCategory(String category) { this.category = category; }
}
