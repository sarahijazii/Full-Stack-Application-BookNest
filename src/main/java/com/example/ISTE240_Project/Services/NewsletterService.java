package com.example.ISTE240_Project.Services;

import com.example.ISTE240_Project.Models.NewsletterSubscriber;
import com.example.ISTE240_Project.modelsDAO.NewsletterRepository;
import org.springframework.stereotype.Service;

@Service
public class NewsletterService {

    private final NewsletterRepository repo;

    public NewsletterService(NewsletterRepository repo) {
        this.repo = repo;
    }

    public boolean existsByEmail(String email) {
        return repo.existsByEmail(email);
    }

    public void save(String email) {
        NewsletterSubscriber subscriber = new NewsletterSubscriber(email);
        repo.save(subscriber);
    }
}
