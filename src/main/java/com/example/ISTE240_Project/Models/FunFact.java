package com.example.ISTE240_Project.Models;

import jakarta.persistence.*;

@Entity
public class FunFact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fact;

    public FunFact() {}

    public FunFact(String fact) {
        this.fact = fact;
    }

    public Long getId() {
        return id;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }
}
