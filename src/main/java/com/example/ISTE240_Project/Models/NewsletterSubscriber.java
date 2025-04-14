package com.example.ISTE240_Project.Models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class NewsletterSubscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private LocalDateTime subscribedAt = LocalDateTime.now();

    // Constructors
    public NewsletterSubscriber() {}

    public NewsletterSubscriber(String email) {
        this.email = email;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDateTime getSubscribedAt() {
        return subscribedAt;
    }
    public void setSubscribedAt(LocalDateTime subscribedAt) {
        this.subscribedAt = subscribedAt;
    }
}
