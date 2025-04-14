package com.example.ISTE240_Project.Services;

import com.example.ISTE240_Project.Models.Book;
import com.example.ISTE240_Project.modelsDAO.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    // Get books released THIS year
    public List<Book> getNewReleases() {
        LocalDate start = LocalDate.of(LocalDate.now().getYear(), 1, 1);
        LocalDate end = LocalDate.of(LocalDate.now().getYear(), 12, 31);
        return repo.findByReleaseDateBetween(start, end);
    }

    // Get books that will be released in the FUTURE
    public List<Book> getUpcomingReleases() {
        return repo.findByReleaseDateAfter(LocalDate.now());
    }

    public List<Book> getTwentiethCenturyBooks() {
        return repo.findByReleaseDateBetween(LocalDate.of(1900, 1, 1), LocalDate.of(2000, 12, 31));
    }

    public List<Book> getByGenre(String genre) {
        return repo.findByGenreIgnoreCase(genre);
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

}