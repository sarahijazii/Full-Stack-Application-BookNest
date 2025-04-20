package com.example.ISTE240_Project.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "nobel_prizes")
public class NobelPrize {

    @Id // Primary key for the NobelPrize entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "award_year")
    private int awardYear;

    @Column(name = "image_path")
    private String imagePath;

    // DEFAULT CONSTRUCTOR
    public NobelPrize() {}

    // CONSTRUCTOR
    public NobelPrize(String name, int awardYear, String imagePath) {
        this.name = name;
        this.awardYear = awardYear;
        this.imagePath = imagePath;
    }

    // GETTERS & SETTERS FOR NAME
    public String getName() { return name;}
    public void setName(String name) { this.name = name;}

    // GETTERS & SETTERS FOR AWARD YEAR
    public int getAwardYear() { return awardYear;}
    public void setAwardYear(int awardYear) { this.awardYear = awardYear;}

    // GETTERS & SETTERS FOR AUTHOR IMAGES
    public String getImagePath() { return imagePath;}
    public void setImagePath(String imagePath) { this.imagePath = imagePath;}
}