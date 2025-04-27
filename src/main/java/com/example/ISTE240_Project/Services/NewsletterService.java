package com.example.ISTE240_Project.Services;

import com.example.ISTE240_Project.Models.NewsletterSubscriber;
import com.example.ISTE240_Project.modelsDAO.NewsletterRepository;
import org.springframework.stereotype.Service;

@Service
public class NewsletterService {

    // Repository to interact with the newsletter_subscriber table
    private final NewsletterRepository repo;

    // Constructor to inject the NewsletterRepository
    public NewsletterService(NewsletterRepository repo) {
        this.repo = repo;
    }

    // Check if a subscriber already exists by email
    public boolean existsByEmail(String email) {
        return repo.existsByEmail(email);
    }

    // Save a new subscriber to the database
    public void save(String email) {
        NewsletterSubscriber subscriber = new NewsletterSubscriber(email);
        repo.save(subscriber);
    }
}