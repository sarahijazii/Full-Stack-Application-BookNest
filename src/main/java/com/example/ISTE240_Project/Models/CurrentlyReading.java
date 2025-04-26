package com.example.ISTE240_Project.Models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="CURRENTLY_READING",uniqueConstraints = @UniqueConstraint(columnNames = {"email", "isbn"})) // disables user from adding the same book multiple times
public class CurrentlyReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

    @Column
    private int pagesRead;

    @Column
    private LocalDate startDate;

    @Column
    private int progressBarPercentage;


    // Default Constructor
    public CurrentlyReading() {
    }

    // GETTERS
    public int getId() {return id;}
    public String getIsbn() {return isbn;}
    public String getTitle() {return title;}
    public String getAuthor() {return author;}
    public String getDescription() {return description;}
    public String getGenre() {return genre;}
    public int getPageCount() {return pageCount;}
    public String getThumbnailUrl() {return thumbnailUrl;}
    public LocalDate getPublicationDate() {return publicationDate;}
    public String getEmail() {return email;}
    public int getPagesRead() {return pagesRead;}
    public LocalDate getStartDate() {return startDate;}
    public int getProgressBarPercentage() {return progressBarPercentage;}

    // SETTERS
    public void setId(int id) {this.id = id;}
    public void setIsbn(String isbn) {this.isbn = isbn;}
    public void setTitle(String title) {this.title = title;}
    public void setAuthor(String author) {this.author = author;}
    public void setDescription(String description) {this.description = description;}
    public void setGenre(String genre) {this.genre = genre;}
    public void setPageCount(int pageCount) {this.pageCount = pageCount;}
    public void setThumbnailUrl(String thumbnailUrl) {this.thumbnailUrl = thumbnailUrl;}
    public void setPublicationDate(LocalDate publicationDate) {this.publicationDate = publicationDate;}
    public void setEmail(String email) {this.email = email;}
    public void setPagesRead(int pagesRead) {this.pagesRead = pagesRead;}
    public void setStartDate(LocalDate startDate) {this.startDate = startDate;}
    public void setProgressBarPercentage(int progressBarPercentage) {this.progressBarPercentage = progressBarPercentage;}

}






