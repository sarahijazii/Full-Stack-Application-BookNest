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

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public Book getBookById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Book> getNewReleases() {
        LocalDate yearStart = LocalDate.of(LocalDate.now().getYear(), 1, 1);
        LocalDate yearEnd = LocalDate.of(LocalDate.now().getYear(), 12, 31);
        return repo.findByPublicationDateBetween(yearStart, yearEnd);
    }

    public List<Book> getByGenre(String genre) {
        return repo.findByGenreIgnoreCase(genre);
    }

    public List<Book> getMemoirs() {
        return repo.findByGenreIgnoreCaseIn(List.of("Non-Fiction", "Biography", "nonfiction"));
    }

    public List<Book> getTwentiethCenturyBooks() {
        return repo.findByPublicationDateBetween(LocalDate.of(1900, 1, 1), LocalDate.of(1999, 12, 31));
    }

    public List<Book> getUpcomingReleases() {
        return repo.findByPublicationDateBetween(LocalDate.now().plusDays(1), LocalDate.of(2100, 1, 1));
    }
}
