package com.example.ISTE240_Project.Services;

import com.example.ISTE240_Project.Models.Quote;
import com.example.ISTE240_Project.modelsDAO.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteService {

    //repository to interact with the quote table
    private final QuoteRepository repo;

    // constructor to inject the QuoteRepository
    public QuoteService(QuoteRepository repo) {
        this.repo = repo;
    }

    // get a random quote from the database
    public Quote getRandomQuote() {
        List<Quote> quotes = repo.findAll();

        // if no quotes found, return a default quote
        if (quotes.isEmpty()) return new Quote("Read more, worry less.", "Unknown");

        // otherwise, it return a random quote
        return quotes.get(new Random().nextInt(quotes.size()));
    }
}