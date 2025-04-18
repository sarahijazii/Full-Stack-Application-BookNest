// This Java page will be used as a model page for the Book's info
// when the user clicks 'see more' button in the Nobel Prize Page
package com.example.nobel_prize.models;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "image")
    private String image;

    //DEFAULT CONSTRUCTOR
    public Book() {}

    //CONSTRUCTOR
    public Book(String title, String image) {
        this.title = title;
        this.image = image;
    }

    // GETTERS
    public String getTitle() {return title;}
    public String getImage() {return image;}

    // SETTERS
    public void setTitle(String title) {this.title = title;}
    public void setImage(String image) {this.image = image;}
}