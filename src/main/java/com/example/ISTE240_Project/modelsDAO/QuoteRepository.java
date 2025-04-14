package com.example.ISTE240_Project.modelsDAO;

import com.example.ISTE240_Project.Models.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Long> {}
