package com.example.ISTE240_Project.Models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book {

    @Id // Primary Key for the Books entity
    private int id;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private String genre;

    @Column
    private String description;

    @Column
    private String isbn;

    @Column(name = "page_count")
    private int pageCount;

    @Column(name = "thumbnail_url")
    private String thumbnailUrl;

    @Column(name = "publication_date")
    private LocalDate publicationDate;


    // GETTERS
    public int getId() {return id;}
    public String getIsbn() {return isbn;}
    public String getTitle() {return title;}
    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}
    public String getDescription() {return description;}
    public String getGenre() {return genre;}
    public int getPageCount() {return pageCount;}
    public String getThumbnailUrl() {return thumbnailUrl;}
    public LocalDate getPublicationDate() {return publicationDate;}


    // SETTERS
    public void setId(int id) {this.id = id;}
    public void setIsbn(String isbn) {this.isbn = isbn;}
    public void setTitle(String title) {this.title = title;}
    public void setDescription(String description) {this.description = description;}
    public void setGenre(String genre) {this.genre = genre;}
    public void setPageCount(int pageCount) {this.pageCount = pageCount;}
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
    public void setPublicationDate(LocalDate publicationDate) {this.publicationDate = publicationDate;}

}

