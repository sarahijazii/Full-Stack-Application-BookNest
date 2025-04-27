package com.example.ISTE240_Project.Services;

import com.example.ISTE240_Project.Models.FunFact;
import com.example.ISTE240_Project.modelsDAO.FunFactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class FunFactService {

    // Repository to interact with the fun_facts table
    private final FunFactRepository repo;

    // Constructor to inject the FunFactRepository
    public FunFactService(FunFactRepository repo) {
        this.repo = repo;
    }

    // Get a random fun fact from the database
    public FunFact getRandomFunFact() {
        List<FunFact> facts = repo.findAll(); // Fetch all fun facts
        if (facts.isEmpty())
            return new FunFact("Books are awesome!"); // Default message if no facts found
        return facts.get(new Random().nextInt(facts.size())); // Return a random fact
    }
}