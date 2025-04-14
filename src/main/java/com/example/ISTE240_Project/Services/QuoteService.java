package com.example.ISTE240_Project.Services;

import com.example.ISTE240_Project.Models.Quote;
import com.example.ISTE240_Project.modelsDAO.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteService {

    private final QuoteRepository repo;

    public QuoteService(QuoteRepository repo) {
        this.repo = repo;
    }

    public Quote getRandomQuote() {
        List<Quote> quotes = repo.findAll();
        if (quotes.isEmpty()) return new Quote("Read more, worry less.", "Unknown");
        return quotes.get(new Random().nextInt(quotes.size()));
    }
}
