// This Java page will be used as a model page for the Author's info
// when the user clicks 'see more' button in the Nobel Prize Page
package com.example.ISTE240_Project.Models;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String language;
    private String dob;
    private String residence;

    @Column(name = "prize_motivation", columnDefinition = "TEXT")
    private String prizeMotivation;

    @Column(columnDefinition = "TEXT")
    private String biography;

    @Column(name = "wiki_link")
    private String wikiLink;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id") // foreign key in Book table
    private List<NobelBook> books;

    //DEFAULT CONSTRUCTOR
    public Author() {}

    //CONSTRUCTORS
    public Author(String name, String language, String dob, String residence, String prizeMotivation, String biography, String wikiLink, List<NobelBook> books) {
        this.name = name;
        this.language = language;
        this.dob = dob;
        this.residence = residence;
        this.prizeMotivation = prizeMotivation;
        this.biography = biography;
        this.wikiLink = wikiLink;
        this.books = books;
    }

    // GETTERS
    public String getName() {return name;}
    public String getLanguage() {return language;}
    public String getDob() {return dob;}
    public String getResidence() {return residence;}
    public String getPrizeMotivation() {return prizeMotivation;}
    public String getBiography() {return biography;}
    public String getWikiLink() {return wikiLink;}
    public List<NobelBook> getBooks() {return books;}

    // SETTERS
    public void setName(String name) {this.name = name;}
    public void setLanguage(String language) {this.language = language;}
    public void setDob(String dob) {this.dob = dob;}
    public void setResidence(String residence) {this.residence = residence;}
    public void setPrizeMotivation(String prizeMotivation) { this.prizeMotivation = prizeMotivation;}
    public void setBiography(String biography) {this.biography = biography;}
    public void setWikiLink(String wikiLink) {this.wikiLink = wikiLink;}
    public void setBooks(List<NobelBook> books) {this.books = books;}
}