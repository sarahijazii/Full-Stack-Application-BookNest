package com.example.ISTE240_Project.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "fun_facts")
public class NobelFunFact {

    @Id // Primary key for the FunFacts entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    // DEFAULT CONSTRUCTOR
    public NobelFunFact() {}

    // CONSTRUCTOR
    public NobelFunFact(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // GETTERS & SETTERS
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}