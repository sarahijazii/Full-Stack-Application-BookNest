package com.example.ISTE240_Project.Controllers;

import com.example.ISTE240_Project.Models.Author;
import com.example.ISTE240_Project.Models.NobelFunFact;
import com.example.ISTE240_Project.Models.NobelPrize;
import com.example.ISTE240_Project.Models.NotableSpeech;
import com.example.ISTE240_Project.Services.AuthorService;
import com.example.ISTE240_Project.Services.NobelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

@Controller
public class NobelController {

    //INJECTING THE 'nobelService' TO ACCESS WINNERS DATA
    private final NobelService nobelService;

    //CONSTRUCTOR-BASED DEPENDENCY INJECTION
    @Autowired
    public NobelController(NobelService nobelService) {
        this.nobelService = nobelService;
    }

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors/{name}")
    public String getAuthorPage(@PathVariable String name, Model model) {
        Author author = authorService.getAuthorByName(name);
        model.addAttribute("author", author);
        return "authors"; // This should map to author.mustache
    }

    //MAPPING FOR THE NOBEL PRIZE PAGE
    @GetMapping("/nobel")
    public String getNobelPage(Model model) {

        // ADDING FUN FACTS DATA
        List<NobelFunFact> funFacts = Arrays.asList(
                new NobelFunFact("Youngest Literature Winner", "Rudyard Kipling (42 years old, 1907)"),
                new NobelFunFact("Most Nominated Author", "Graham Greene (20+ nominations, but never won)"),
                new NobelFunFact("Only Songwriter to Win", "Bob Dylan (2016) – The first musician awarded the prize, for his poetic lyrics"),
                new NobelFunFact("A Winner Who Refused the Prize", "Jean-Paul Sartre (1964) – The French philosopher and writer declined the award, saying a writer should not accept official honors"),
                new NobelFunFact("A Winner Who Didn’t Know She Won", "Doris Lessing (2007) – She found out about her win from journalists waiting outside her house and responded with, \"Oh Christ!\"")
        );
        model.addAttribute("funFacts", funFacts);

        //ADDING NOTABLE SPEECHES DATA
        List<NotableSpeech> speeches = Arrays.asList(
                new NotableSpeech("William Faulkner", 1950, "https://www.nobelprize.org/prizes/literature/1949/faulkner/speech/"),
                new NotableSpeech("Toni Morrison", 1993, "https://www.nobelprize.org/prizes/literature/1993/morrison/speech/"),
                new NotableSpeech("Ernest Hemingway", 1954, "https://www.nobelprize.org/prizes/literature/1954/hemingway/speech/"),
                new NotableSpeech("Bob Dylan", 2016, "https://www.nobelprize.org/prizes/literature/2016/dylan/speech/")
        );
        model.addAttribute("speeches", speeches);

        //ADDING WINNERS DATA FORM THE SERVICE TO THE MODEL
        List<NobelPrize> winners = nobelService.getAllWinners();
        model.addAttribute("winners", winners);

        return "nobel"; // RETURNING THE MUSTACHE TEMPLATE
    }
}
