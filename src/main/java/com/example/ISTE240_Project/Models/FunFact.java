package com.example.nobel_prize.models;

import jakarta.persistence.*;

@Entity
@Table(name = "fun_facts")
public class FunFact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    // DEFAULT CONSTRUCTOR
    public FunFact() {}

    // CONSTRUCTOR
    public FunFact(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // GETTERS & SETTERS
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}