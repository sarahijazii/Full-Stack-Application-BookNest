package com.example.ISTE240_Project.modelsDAO;

import com.example.ISTE240_Project.Models.NobelFunFact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository interface for NobelFunFact entity

@Repository
public interface NobelFunFactRepository extends JpaRepository<NobelFunFact, Long> {}