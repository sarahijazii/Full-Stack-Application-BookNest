package com.example.ISTE240_Project.Controllers;

import com.example.ISTE240_Project.Models.Book;
import com.example.ISTE240_Project.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DiscoverController {

    @Autowired
    private BookService bookService;

    @GetMapping("/Discover")
    public String getSearch(Model model) {
        List<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("displayedBooks", allBooks);
        return "Discover";
    }

    @GetMapping("/Discover/{genre}")
    public String getBooksByGenre(@PathVariable("genre") String genre, Model model) {
        List<Book> books = bookService.getByGenre(genre);
        model.addAttribute("displayedBooks", books);
        model.addAttribute("genre", genre);
        return "Discover";
    }

}
