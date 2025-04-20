package com.example.ISTE240_Project.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "notable_speeches")
public class NotableSpeech {

    @Id // Primary key for the NOTABLE SPEECHES entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private int year;

    @Column(columnDefinition = "TEXT")
    private String url;

    // DEFAULT CONSTRUCTOR
    public NotableSpeech() {}

    // CONSTRUCTOR
    public NotableSpeech(String name, int year, String url) {
        this.name = name; this.year = year; this.url = url;
    }

    // GETTERS & SETTERS
    public String getName() { return name;}
    public void setName(String name) {this.name = name;}
    public int getYear() {return year;}
    public void setYear(int year) {this.year = year;}
    public String getUrl() {return url;}
    public void setUrl(String url) {this.url = url;}
}