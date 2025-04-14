package com.example.ISTE240_Project.Controllers;

import com.example.ISTE240_Project.Models.Book;
import com.example.ISTE240_Project.Services.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/new-releases")
    public List<Book> newReleases() {
        return service.getNewReleases();
    }

    @GetMapping("/20th-century")
    public List<Book> classicBooks() {
        return service.getTwentiethCenturyBooks();
    }

    @GetMapping("/genre/{genre}")
    public List<Book> byGenre(@PathVariable String genre) {
        return service.getByGenre(genre);
    }

    @GetMapping("/upcoming")
    public List<Book> upcomingBooks() {
        return service.getUpcomingReleases();
    }
}