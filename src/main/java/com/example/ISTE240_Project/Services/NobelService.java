package com.example.ISTE240_Project.Services;

import com.example.ISTE240_Project.Models.NobelPrize;
import com.example.ISTE240_Project.modelsDAO.NobelRepository;
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
