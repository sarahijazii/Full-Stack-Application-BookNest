package com.example.ISTE240_Project.Services;

import com.example.ISTE240_Project.Models.FunFact;
import com.example.ISTE240_Project.modelsDAO.FunFactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class FunFactService {
    private final FunFactRepository repo;

    public FunFactService(FunFactRepository repo) {
        this.repo = repo;
    }

    public FunFact getRandomFunFact() {
        List<FunFact> facts = repo.findAll();
        if (facts.isEmpty()) return new FunFact("Books are awesome!");
        return facts.get(new Random().nextInt(facts.size()));
    }
}
