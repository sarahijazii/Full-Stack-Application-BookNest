package com.example.ISTE240_Project.Controllers;

import com.example.ISTE240_Project.Models.Quote;
import com.example.ISTE240_Project.Services.BookService;
import com.example.ISTE240_Project.Services.FunFactService;
import com.example.ISTE240_Project.Services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final BookService bookService;
    private final QuoteService quoteService;

    @Autowired
    private final FunFactService funFactService;

    public HomeController(BookService bookService, QuoteService quoteService, FunFactService funFactService) {
        this.bookService = bookService;
        this.quoteService = quoteService;
        this.funFactService = funFactService;
    }

    @GetMapping("/home")
    public String getHome(Model model) {
        model.addAttribute("newReleases", bookService.getNewReleases());
        model.addAttribute("twentiethCentury", bookService.getTwentiethCenturyBooks());
        model.addAttribute("thrillers", bookService.getByGenre("Thriller"));
        model.addAttribute("memoirs", bookService.getMemoirs());
        model.addAttribute("upcoming", bookService.getUpcomingReleases());
        model.addAttribute("allBooks", bookService.getAllBooks());

        model.addAttribute("quote", quoteService.getRandomQuote());
        model.addAttribute("funFact", funFactService.getRandomFunFact());

        return "home";
    }

}
