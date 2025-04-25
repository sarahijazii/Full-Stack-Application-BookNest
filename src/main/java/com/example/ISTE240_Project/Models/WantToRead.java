package com.example.ISTE240_Project.Models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="WANT_TO_READ")
public class WantToRead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String isbn;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private String description;

    @Column
    private String genre;

    @Column
    private int pageCount;

    @Column(name = "thumbnail_url")
    private String thumbnailUrl;

    @Column
    private LocalDate publicationDate;

    @Column
    private String email;


    //  Default Constructor
    public WantToRead() {}

    // GETTERS
    public Long getId() {return id;}
    public String getIsbn() {return isbn;}
    public String getTitle() {return title;}
    public String getAuthor() {return author;}
    public String getDescription() {return description;}
    public String getGenre() {return genre;}
    public int getPageCount() {return pageCount;}
    public String getThumbnailUrl() {return thumbnailUrl;}
    public LocalDate getPublicationDate() {return publicationDate;}
    public String getEmail() {return email;}


    // SETTERS
    public void setId(Long id) {this.id = id;}
    public void setIsbn(String isbn) {this.isbn = isbn;}
    public void setTitle(String title) {this.title = title;}
    public void setAuthor(String author) {this.author = author;}
    public void setDescription(String description) {this.description = description;}
    public void setGenre(String genre) {this.genre = genre;}
    public void setPageCount(int pageCount) {this.pageCount = pageCount;}
    public void setThumbnailUrl(String thumbnailUrl) {this.thumbnailUrl = thumbnailUrl;}
    public void setPublicationDate(LocalDate publicationDate) {this.publicationDate = publicationDate;}
    public void setEmail(String email) {this.email = email;}

}




