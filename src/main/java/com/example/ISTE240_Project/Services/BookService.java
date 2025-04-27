package com.example.ISTE240_Project.Services;

import com.example.ISTE240_Project.Models.Book;
import com.example.ISTE240_Project.modelsDAO.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookService {

    // Repository to interact with the database
    private final BookRepository repo;

    // contructor to inject the book repo
    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    // get all the books from the database 
    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    // find a book but its id
    public Book getBookById(int id) {
        return repo.findById(id).orElse(null);
    }

    // gets the books that are published in the current year
    public List<Book> getNewReleases() {
        LocalDate yearStart = LocalDate.of(LocalDate.now().getYear(), 1, 1);
        LocalDate yearEnd = LocalDate.of(LocalDate.now().getYear(), 12, 31);
        return repo.findByPublicationDateBetween(yearStart, yearEnd);
    }

    // gets books based on genre and is not case sensitive
    public List<Book> getByGenre(String genre) {
        return repo.findByGenreIgnoreCase(genre);
    }

    public List<Book> getMemoirs() {
        return repo.findByGenreIgnoreCaseIn(List.of("Non-Fiction", "Biography", "nonfiction"));
    }

    // get books published between 1900 and 1999
    public List<Book> getTwentiethCenturyBooks() {
        return repo.findByPublicationDateBetween(LocalDate.of(1900, 1, 1), LocalDate.of(1999, 12, 31));
    }

    // gets future books (released later)
    public List<Book> getUpcomingReleases() {
        return repo.findByPublicationDateBetween(LocalDate.now().plusDays(1), LocalDate.of(2100, 1, 1));
    }
}
