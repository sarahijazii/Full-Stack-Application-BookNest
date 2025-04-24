package com.example.ISTE240_Project.Models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book {
    @Id
    private int id;

    private String title;
    private String author;
    private String genre;
    private String description;
    private String isbn;

    @Column(name = "page_count")
    private Integer pageCount;

    @Column(name = "thumbnail_url")
    private String thumbnailUrl;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

}

