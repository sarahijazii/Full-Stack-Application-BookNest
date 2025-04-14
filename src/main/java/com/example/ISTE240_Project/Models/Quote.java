package com.example.ISTE240_Project.Models;

import jakarta.persistence.*;

@Entity
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private String author;

    // Constructors
    public Quote() {}
    public Quote(String text, String author) {
        this.text = text;
        this.author = author;
    }

    // Getters and setters
    public Long getId() { return id; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
}
