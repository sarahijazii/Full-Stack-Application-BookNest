package com.example.ISTE240_Project.Controllers;

import com.example.ISTE240_Project.Models.Book;
import com.example.ISTE240_Project.Services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/book/{id}")
    public String getBookDetails(@PathVariable Long id, Model model) {
        Book book = service.getBookById(id);
        if (book == null) {
            return "redirect:/home";
        }

        model.addAttribute("book", book);
        return "book-details";
    }
}