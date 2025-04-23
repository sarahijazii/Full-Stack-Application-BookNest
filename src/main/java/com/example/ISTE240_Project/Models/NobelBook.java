// This Java page will be used as a model page for the Book's info
// when the user clicks 'see more' button in the Nobel Prize Page
package com.example.ISTE240_Project.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "nobel-books")
public class NobelBook {
    
    @Id // Primary key for the BOOKS entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "image")
    private String image;

    //DEFAULT CONSTRUCTOR
    public NobelBook() {}

    //CONSTRUCTOR
    public NobelBook(String title, String image) {
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