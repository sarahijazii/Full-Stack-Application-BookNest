package com.example.ISTE240_Project.modelsDAO;

import com.example.ISTE240_Project.Models.NewsletterSubscriber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsletterRepository extends JpaRepository<NewsletterSubscriber, Long> {
    boolean existsByEmail(String email);
}
