package com.example.nobel_prize.services;

import com.example.nobel_prize.models.NobelPrize;
import com.example.nobel_prize.repository.NobelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NobelService {

    @Autowired
    private NobelRepository nobelRepository;

    @Autowired
    public NobelService(NobelRepository nobelRepository) {
        this.nobelRepository = nobelRepository;
    }

    public List<NobelPrize> getAllWinners() {
        return nobelRepository.findAll();
    }
}
